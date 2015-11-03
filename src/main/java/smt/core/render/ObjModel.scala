package smt.core.render

import java.lang.Double.{parseDouble => d}
import java.util.Scanner
import javax.vecmath.{Vector2d, Vector3d}

import net.minecraft.client.Minecraft
import net.minecraft.client.renderer.Tessellator
import net.minecraft.util.{IIcon, ResourceLocation}

import scala.collection.mutable

class ObjModel(location: ResourceLocation) {

  private val model = Parser.parse(location)

  def renderAll(tex: IIcon): Unit =
    model.keys.foreach(renderGroup(_, tex))

  def renderGroup(group: String, tex: IIcon): Unit = {
    val tes = Tessellator.instance
    val uvB = new Vector2d(tex.getMaxU - tex.getMinU, tex.getMaxV - tex.getMaxV)
    model.get(group).get.foreach(v => {
      if(v.normal != null) tes.setNormal(v.normal.x.toFloat, v.normal.y.toFloat, v.normal.z.toFloat)
      if(v.uv != null) tes.setTextureUV(tex.getMinU + uvB.x * v.uv.x, tex.getMinV + uvB.y * v.uv.y)
      tes.addVertex(v.pos.x, v.pos.y, v.pos.z)
    })
  }

  object Parser {

    def parse(location: ResourceLocation): Map[String, List[Vertex]] = {
      try {
        val file = Minecraft.getMinecraft.getResourceManager.
          getResource(location).getInputStream
        try {
          val data = new mutable.HashMap[String, mutable.MutableList[Vertex]]
          var vertexes = group("default", data)
          var nextVn = 0
          var nextVt = 0
          val scan = new Scanner(file)
          while (scan.hasNextLine)
            scan.nextLine.split(" ") match {
              case g if g(0) equals "g" => vertexes = group(g(1), data)
              case v if v(0) equals "v" => vertexes += new Vertex(new Vector3d(d(v(1)), d(v(2)), d(v(3))))
              case vn if vn(0) equals "vn" => vertexes(nextVn).normal = new Vector3d(d(vn(1)), d(vn(2)), d(vn(3))); nextVn += 1
              case vt if vt(0) equals "vt" => vertexes(nextVt).uv = new Vector2d(d(vt(1)), d(vt(2))); nextVt += 1
              case another =>
            }
          data.mapValues(_.toList).toMap
        } finally if(file != null) file.close()
      } catch {case e: Exception => throw new RuntimeException("Can't load model " + location, e);}
    }

    private def group(group: String, data: mutable.HashMap[String, mutable.MutableList[Vertex]]) =
      if(data.contains(group)) data.get(group).get else data.put(group, new mutable.MutableList[Vertex]).get

    class Vertex(val pos: Vector3d) {
      var normal: Vector3d = null
      var uv: Vector2d = null
    }

  }

}
