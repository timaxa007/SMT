package smt.core.render

import org.lwjgl.opengl.GL11._

/**
 * Simple scala wrapper around OpenGL display lists
 * @param renderCalls function, which contains OpenGL calls
 */
class DisplayList(renderCalls: => Unit) extends Function[Unit, Unit] {

  var deleted = false
  val displayListId = glGenLists(1)
  glNewList(displayListId, GL_COMPILE)
  glCallList(displayListId)
  renderCalls
  glEndList()

  def callList(): Unit = if(!deleted) glCallList(displayListId)
  override def apply(dummy: Unit): Unit = callList()

  def deleteList(): Unit = glDeleteLists(displayListId, 1); deleted = true
  override def finalize(): Unit = deleteList()

}
