import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Random;
import java.util.Scanner;
import java.util.StringTokenizer;

import javax.jws.soap.SOAPBinding;
import javax.media.opengl.GL2;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLCapabilities;
import javax.media.opengl.GLEventListener;
import javax.media.opengl.GLProfile;
import javax.media.opengl.awt.GLCanvas;
import javax.swing.JFrame;

public class Classwork05_CohenSutherland implements GLEventListener {

	static GLProfile profile = GLProfile.get(GLProfile.GL2);
	static GLCapabilities capabilities = new GLCapabilities(profile);
	// The canvas
	static GLCanvas glcanvas = new GLCanvas(capabilities);

	public static void main(String[] args) {
		// getting the capabilities object of GL2 profile

		Classwork05_CohenSutherland l = new Classwork05_CohenSutherland();
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
		// gl.glBegin(GL2.GL_POINTS);// static field

		// Rectangle draw
		gl.glColor3f(0f, 0f, 1f);
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


		Random random = new Random();
		for (int i = 0; i < 100; i++) {
			double x0 = random.nextDouble() * (1 - (-1)) + (-1);
			double y0 = random.nextDouble() * (1 - (-1)) + (-1);
			double x1 = random.nextDouble() * (1 - (-1)) + (-1);
			double y1 = random.nextDouble() * (1 - (-1)) + (-1);

			// System.out.println(x0 + " " + y0 + " " + x1 + " " + y1);

			outCode_0 = makeCode(x0, y0);
			outCode_1 = makeCode(x1, y1);

			System.out.println(outCode_0 + " " + outCode_1);

			if (outCode_0 == 0 && outCode_1 == 0) {// accepted
				gl.glBegin(GL2.GL_LINES);

				gl.glColor3f(0f, 1f, 0f);
				gl.glBegin(1);
				gl.glVertex2d(x0, y0);
				gl.glVertex2d(x1, y1);
				gl.glEnd();

			} else if ((outCode_0 & outCode_1) > 0) {//rejected
				gl.glBegin(GL2.GL_LINES);

				gl.glColor3f(1f, 0f, 0f);
				gl.glBegin(1);
				gl.glVertex2d(x0, y0);
				gl.glVertex2d(x1, y1);
				gl.glEnd();
			}
		}
		gl.glFlush();
	}

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

		// System.out.println(x + "  " + y);
		System.out.println(code);
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