import javax.media.opengl.GL2;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLCapabilities;
import javax.media.opengl.GLEventListener;
import javax.media.opengl.GLProfile;
import javax.media.opengl.awt.GLCanvas;
import javax.swing.JFrame;

public class Cube implements GLEventListener {

	static GLProfile profile = GLProfile.get(GLProfile.GL2);
	static GLCapabilities capabilities = new GLCapabilities(profile);
	// The canvas
	static GLCanvas glcanvas = new GLCanvas(capabilities);

	public static void main(String[] args) {
		// getting the capabilities object of GL2 profile

		Cube l = new Cube();
		// creating frame
		glcanvas.addGLEventListener(l);
		glcanvas.setSize(600, 400);

		final JFrame frame = new JFrame("straight Line");
		// adding canvas to frame
		frame.getContentPane().add(glcanvas);
		frame.setSize(frame.getContentPane().getPreferredSize());
		frame.setVisible(true);

	}

	public void display(GLAutoDrawable drawable) {
		final GL2 gl = drawable.getGL().getGL2();

		// initializing coordinates
		double x1 = 0.0, y1 = 0.0, x2 = 0.5, y2 = 0.0, x3 = 0.0, y3 = 0.5, x4 = 0.5, y4 = 0.5;
		double x5 = 0.2, y5 = 0.3, x6 = 0.7, y6 = 0.3, x7 = 0.2, y7 = 0.8, x8 = 0.7, y8 = 0.8;

		// initial cube

		// front
		drawLine(gl, x1, y1, x2, y2);
		drawLine(gl, x1, y1, x3, y3);
		drawLine(gl, x2, y2, x4, y4);
		drawLine(gl, x3, y3, x4, y4);
		// back
		drawLine(gl, x5, y5, x6, y6);
		drawLine(gl, x5, y5, x7, y7);
		drawLine(gl, x6, y6, x8, y8);
		drawLine(gl, x7, y7, x8, y8);
		// connect
		drawLine(gl, x1, y1, x5, y5);
		drawLine(gl, x2, y2, x6, y6);
		drawLine(gl, x3, y3, x7, y7);
		drawLine(gl, x4, y4, x8, y8);

		// 45 degrees rotated coordinates
		double x11 = getRotatedX(x1, y1);
		double y11 = getRotatedY(x1, y1);

		double x12 = getRotatedX(x2, y2);
		double y12 = getRotatedY(x2, y2);

		double x13 = getRotatedX(x3, y3);
		double y13 = getRotatedY(x3, y3);

		double x14 = getRotatedX(x4, y4);
		double y14 = getRotatedY(x4, y4);

		double x15 = getRotatedX(x5, y5);
		double y15 = getRotatedY(x5, y5);

		double x16 = getRotatedX(x6, y6);
		double y16 = getRotatedY(x6, y6);

		double x17 = getRotatedX(x7, y7);
		double y17 = getRotatedY(x7, y7);

		double x18 = getRotatedX(x8, y8);
		double y18 = getRotatedY(x8, y8);

		System.out.println(x11 + " " + y11);
		System.out.println(x12 + " " + y12);
		System.out.println(x13 + " " + y13);

		// rotated cube
		gl.glColor3f(0f, 0f, 1f);
		// front
		drawLine(gl, x11, y11, x12, y12);
		drawLine(gl, x11, y11, x13, y13);
		drawLine(gl, x12, y12, x14, y14);
		drawLine(gl, x13, y13, x14, y14);
		// back
		drawLine(gl, x15, y15, x16, y16);
		drawLine(gl, x15, y15, x17, y17);
		drawLine(gl, x16, y16, x18, y18);
		drawLine(gl, x17, y17, x18, y18);
		// connect
		drawLine(gl, x11, y11, x15, y15);
		drawLine(gl, x12, y12, x16, y16);
		drawLine(gl, x13, y13, x17, y17);
		drawLine(gl, x14, y14, x18, y18);

		gl.glFlush();
	}

	// take gl, x1, y1, x2, y2 and draw line using GL_LINES
	public void drawLine(GL2 gl, double x1, double y1, double x2, double y2) {
		gl.glBegin(GL2.GL_LINES);
		gl.glBegin(1);
		gl.glVertex2d(x1, y1);
		gl.glVertex2d(x2, y2);
		gl.glEnd();
	}

	// takes old x and y value, rotate it by 45 degrees and then return rotated
	// x
	public double getRotatedX(double oldX, double oldY) {
		double newX = oldX * Math.cos(45 * (Math.PI / 180)) - oldY
				* Math.sin(45 * (Math.PI / 180));
		return newX;
	}

	// takes old x and y value, rotate it by 45 degrees and then return rotated
	// y
	public double getRotatedY(double oldX, double oldY) {
		double newY = oldX * Math.sin(45 * (Math.PI / 180)) + oldY
				* Math.cos(45 * (Math.PI / 180));
		return newY;
	}

	public void dispose(GLAutoDrawable arg0) {
		// method body
	}

	public void init(GLAutoDrawable drawable) {
		// method body
		// 4. drive the display() in a loop
	}

	public void reshape(GLAutoDrawable arg0, int arg1, int arg2, int arg3,
			int arg4) {
		// method body
	}
	// end of main
}// end of classimport javax.media.opengl.GL2;