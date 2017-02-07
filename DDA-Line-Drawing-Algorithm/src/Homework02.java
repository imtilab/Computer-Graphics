/*Homework 2
•	Generate 10 random lines (input pair of start and end points)
•	For every line sort the pair according to x values
•	Determine slope for each line
•	Implement DDA algorithm 
 */
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

public class Homework02 implements GLEventListener {

	static GLProfile profile = GLProfile.get(GLProfile.GL2);
	static GLCapabilities capabilities = new GLCapabilities(profile);
	// The canvas
	static GLCanvas glcanvas = new GLCanvas(capabilities);

	public static void main(String[] args) {
		// getting the capabilities object of GL2 profile

		Homework02 l = new Homework02();
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
		gl.glBegin(GL2.GL_POINTS);// static field

		for (int i = 1; i <= 10; i++) {
			Random random = new Random();

			Double x1 = random.nextDouble() * (8 - 1) + 1;
			Double y1 = random.nextDouble() * (8 - 1) + 1;
			Double x2 = random.nextDouble() * (8 - 1) + 1;
			Double y2 = random.nextDouble() * (8 - 1) + 1;
			// System.out.println(x1 + " " + y1 + " " + x2 + " " + y2);

			if (x1 > x2) {//x2>x1 to move left to right positive
				Double p = x1;
				Double q = y1;
				x1 = x2;
				y1 = y2;
				x2 = p;
				y2 = q;
			}
			
			if (x2 < y2) {//x2>y2 at zone 0
				Double temp = y2;
				y2 = x2;
				x2 = temp;
			}

			double m = (y2 - y1) / (x2 - x1);
			System.out.println("Slope m for line "+i+": " + m);

			x1 = x1 / 10;
			y1 = y1 / 10;
			x2 = x2 / 10;
			y2 = y2 / 10;
			Double mScale = m / 100;
			for (; x1 <= x2;) {
				// System.out.println(x1 + " " + y1 + " " + x2 + " " + y2 + " "
				// + mScale);
				gl.glVertex2d(x1, y1);

				if (-1 < mScale && mScale < 1) {
					x1 = x1 + 0.01;
					y1 = y1 + mScale;
				} else {
					y1 = y1 + 0.01;
					x1 = x1 + (1 / mScale);
				}
			}
		}

		gl.glEnd();
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