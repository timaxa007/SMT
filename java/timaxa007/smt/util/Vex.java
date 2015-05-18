package timaxa007.smt.util;

public class Vex {
	//-------------------------------------------------------------
	public static class Integer2 {

		public int x, z;

		public Integer2(int x, int z) {
			this.x = x;this.z = z;
		}

		public static Integer2 create(int x, int z) {
			return new Integer2(x, z);
		}

		public void edit(int x, int z) {
			this.x = x;this.z = z;
		}

		public String toString() {
			return "(" + this.x + ", " + this.z + ")";
		}

	}
	//-------------------------------------------------------------
	public static class Integer3 {

		public int x, y, z;

		public Integer3(int x, int y, int z) {
			this.x = x;this.y = y;this.z = z;
		}

		public static Integer3 create(int x, int y, int z) {
			return new Integer3(x, y, z);
		}

		public void edit(int x, int y, int z) {
			this.x = x;this.y = y;this.z = z;
		}

		public String toString() {
			return "(" + this.x + ", " + this.y + ", " + this.z + ")";
		}

	}
	//-------------------------------------------------------------
	public static class Integer6 {

		public int x, y, z, u, v, w;

		public Integer6(int x, int y, int z, int u, int v, int w) {
			this.x = x;this.y = y;this.z = z;this.u = u;this.v = v;this.w = w;
		}

		public static Integer6 create(int x, int y, int z, int u, int v, int w) {
			return new Integer6(x, y, z, u, v, w);
		}

		public void edit(int x, int y, int z, int u, int v, int w) {
			this.x = x;this.y = y;this.z = z;this.u = u;this.v = v;this.w = w;
		}

		public String toString() {
			return "(" + this.x + ", " + this.y + ", " + this.z + ", " + this.u + ", " + this.v + ", " + this.w + ")";
		}

	}
	//-------------------------------------------------------------
	public static class Double2 {

		public double x, z;

		public Double2(double x, double z) {
			this.x = x;this.z = z;
		}

		public static Double2 create(double x, double z) {
			return new Double2(x, z);
		}

		public void edit(double x, double z) {
			this.x = x;this.z = z;
		}

		public String toString() {
			return "(" + this.x + ", " + this.z + ")";
		}

	}
	//-------------------------------------------------------------
	public static class Double3 {

		public double x, y, z;

		public Double3(double x, double y, double z) {
			this.x = x;this.y = y;this.z = z;
		}

		public static Double3 create(double x, double y, double z) {
			return new Double3(x, y, z);
		}

		public void edit(double x, double y, double z) {
			this.x = x;this.y = y;this.z = z;
		}

		public String toString() {
			return "(" + this.x + ", " + this.y + ", " + this.z + ")";
		}

	}
	//-------------------------------------------------------------
	public static class Double6 {

		public double x, y, z, u, v, w;

		public Double6(double x, double y, double z, double u, double v, double w) {
			this.x = x;this.y = y;this.z = z;this.u = u;this.v = v;this.w = w;
		}

		public static Double6 create(double x, double y, double z, double u, double v, double w) {
			return new Double6(x, y, z, u, v, w);
		}

		public void edit(double x, double y, double z, double u, double v, double w) {
			this.x = x;this.y = y;this.z = z;this.u = u;this.v = v;this.w = w;
		}

		public String toString() {
			return "(" + this.x + ", " + this.y + ", " + this.z + ", " + this.u + ", " + this.v + ", " + this.w + ")";
		}

	}
	//-------------------------------------------------------------
	public static class Float2 {

		public float x, z;

		public Float2(float x, float z) {
			this.x = x;this.z = z;
		}

		public static Float2 create(float x, float z) {
			return new Float2(x, z);
		}

		public void edit(float x, float z) {
			this.x = x;this.z = z;
		}

		public String toString() {
			return "(" + this.x + ", " + this.z + ")";
		}

	}
	//-------------------------------------------------------------
	public static class Float3 {

		public float x, y, z;

		public Float3(float x, float y, float z) {
			this.x = x;this.y = y;this.z = z;
		}

		public static Float3 create(float x, float y, float z) {
			return new Float3(x, y, z);
		}

		public void edit(float x, float y, float z) {
			this.x = x;this.y = y;this.z = z;
		}

		public String toString() {
			return "(" + this.x + ", " + this.y + ", " + this.z + ")";
		}

	}
	//-------------------------------------------------------------
	public static class Float6 {

		public float x, y, z, u, v, w;

		public Float6(float x, float y, float z, float u, float v, float w) {
			this.x = x;this.y = y;this.z = z;this.u = u;this.v = v;this.w = w;
		}

		public static Float6 create(float x, float y, float z, float u, float v, float w) {
			return new Float6(x, y, z, u, v, w);
		}

		public void edit(float x, float y, float z, float u, float v, float w) {
			this.x = x;this.y = y;this.z = z;this.u = u;this.v = v;this.w = w;
		}

		public String toString() {
			return "(" + this.x + ", " + this.y + ", " + this.z + ", " + this.u + ", " + this.v + ", " + this.w + ")";
		}

	}
	//-------------------------------------------------------------
}
