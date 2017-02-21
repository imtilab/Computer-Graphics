import java.util.Random;
import javax.media.opengl.GL2;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLCapabilities;
import javax.media.opengl.GLEventListener;
import javax.media.opengl.GLProfile;
import javax.media.opengl.awt.GLCanvas;
import javax.swing.JFrame;

public class Homework04_CohenSutherland implements GLEventListener {

	static GLProfile profile = GLProfile.get(GLProfile.GL2);
	static GLCapabilities capabilities = new GLCapabilities(profile);
	// The canvas
	static GLCanvas glcanvas = new GLCanvas(capabilities);

	public static void main(String[] args) {
		// getting the capabilities object of GL2 profile

		Homework04_CohenSutherland l = new Homework04_CohenSutherland();
		// creating frame
		glcanvas.addGLEventListener(l);
		glcanvas.setSize(600, 400);

		final JFrame frame = new JFrame("straight Homework04_CohenSutherland");
		// adding canvas to frame
		frame.getContentPane().add(glcanvas);
		frame.setSize(frame.getContentPane().getPreferredSize());
		frame.setVisible(true);

	}

	public void display(GLAutoDrawable drawable) {
		final GL2 gl = drawable.getGL().getGL2();
		// gl.glBegin(GL2.GL_POINTS);// static field

		double xmin = -.45;
		double xmax = .45;
		double ymin = -.45;
		double ymax = .45;

		// Rectangle draw
		gl.glColor3f(1f, 0f, 0f);
		gl.glBegin(GL2.GL_LINES);
		gl.glVertex3f(-.45f, -.45f, 0);
		gl.glVertex3f(-.45f, .45f, 0);
		gl.glEnd();
		// edge2
		gl.glBegin(GL2.GL_LINES);
		gl.glVertex3f(-.45f, .45f, 0);
		gl.glVertex3f(.45f, .45f, 0);
		gl.glEnd();
		// edge3
		gl.glBegin(GL2.GL_LINES);
		gl.glVertex3f(-.45f, -.45f, 0);
		gl.glVertex3f(0.45f, -.45f, 0);
		gl.glEnd();
		// edge4
		gl.glBegin(GL2.GL_LINES);
		gl.glVertex3f(.45f, -.45f, 0);
		gl.glVertex3f(0.45f, 0.45f, 0);
		gl.glEnd();

		int outCode, outCode_0, outCode_1 = 0;

		int top = 8;// 1000
		int bottom = 4;// 0100
		int right = 2;// 0010
		int left = 1;// 0001

		// initialize some values
		double x = 0.0, y = 0.0;
		double x5 = 0.0, y5 = 0.0;// keeps values of x0,y0 when updated
		double x6 = 0.0, y6 = 0.0;// keeps values of x1,y1 when updated
		boolean partiallyAccepted = false;// allow to draw only partially
											// accepted lines

		Random random = new Random();
		for (int i = 0; i < 100; i++) {// for 100 lines take values
			double x0 = random.nextDouble() * (1 - (-1)) + (-1);
			double y0 = random.nextDouble() * (1 - (-1)) + (-1);
			double x1 = random.nextDouble() * (1 - (-1)) + (-1);
			double y1 = random.nextDouble() * (1 - (-1)) + (-1);

			// System.out.println("input "+x0 + " " + y0 + " " + x1 + " " + y1);

			outCode_0 = makeCode(x0, y0);
			outCode_1 = makeCode(x1, y1);
			// System.out.println(outCode_0 + " " + outCode_1);

			// keep the outCode values to draw lines perfectly
			int tempOutCode_0 = outCode_0;
			int tempOutCode_1 = outCode_1;

			// if fully accepted or rejected, then break
			// if partially accepted, make it fully accepted and break;
			while (true) {
				if ((outCode_0 | outCode_1) == 0) {// fully accepted
					break;
				} else if ((outCode_0 & outCode_1) > 0) {// rejected
					partiallyAccepted = false;
					break;
				} else {// partially accepted
					partiallyAccepted = true;

					// take rejected area end point's outCode
					if (outCode_0 > 0) {
						outCode = outCode_0;
					} else {
						outCode = outCode_1;
					}

					// find out the outCode region and take new cut x,y value
					if ((outCode & top) > 0) {
						y = (double) ymax;
						x = (double) (x0 + ((y - y0) / (y1 - y0)) * (x1 - x0));
					} else if ((outCode & bottom) > 0) {
						y = (double) ymin;
						x = (double) (x0 + ((y - y0) / (y1 - y0)) * (x1 - x0));
					} else if ((outCode & right) > 0) {
						x = (double) xmax;
						y = (double) (y0 + ((x - x0) / (x1 - x0)) * (y1 - y0));
					} else if ((outCode & left) > 0) {
						x = (double) xmin;
						y = (double) (y0 + ((x - x0) / (x1 - x0)) * (y1 - y0));
					}

					// outCode of rejected area end point is (x0,y0) or (x1, y1)
					// point
					if (outCode == outCode_0) {
						x5 = x0;// keeps the old end point of rejected area
						y5 = y0;

						x0 = x;
						y0 = y;
						outCode_0 = makeCode(x0, y0);
					} else {
						x6 = x1;// keeps the old end point of rejected area
						y6 = y1;

						x1 = x;
						y1 = y;
						outCode_1 = makeCode(x1, y1);
					}
				}
			}// end of while loop

			if (partiallyAccepted) {// draw lines if only partially accepted
				// draw accepted region line (GREEN color)
				gl.glBegin(GL2.GL_LINES);
				gl.glColor3f(0f, 1f, 0f);
				gl.glBegin(1);
				gl.glVertex2d(x0, y0);
				gl.glVertex2d(x1, y1);
				gl.glEnd();

				// draw rejected region line (BLUE color)
				if (tempOutCode_0 > 0) {// if x0,y0 is in rejected area
					gl.glBegin(GL2.GL_LINES);
					gl.glColor3f(0f, 0f, 1f);
					gl.glBegin(1);
					gl.glVertex2d(x5, y5);
					gl.glVertex2d(x0, y0);
					gl.glEnd();
				}
				if (tempOutCode_1 > 0) {// if x1,y1 is in rejected area
					gl.glBegin(GL2.GL_LINES);
					gl.glColor3f(0f, 0f, 1f);
					gl.glBegin(1);
					gl.glVertex2d(x1, y1);
					gl.glVertex2d(x6, y6);
					gl.glEnd();
				}
				partiallyAccepted = false;
			}
		}// if x0,y0 is in rejected area
		gl.glFlush();
	}

	// takes (x,y) values, generate outCode and return outCode
	public int makeCode(double x, double y) {
		double xmin = -.45;
		double xmax = .45;
		double ymin = -.45;
		double ymax = .45;

		int top = 8;
		int bottom = 4;
		int right = 2;
		int left = 1;

		int code = 0;

		if (y > ymax) {
			code += top;
		} else if (y < ymin) {
			code += bottom;
		}

		if (x > xmax) {
			code += right;
		} else if (x < xmin) {
			code += left;
		}
		// System.out.println(code);
		return code;
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