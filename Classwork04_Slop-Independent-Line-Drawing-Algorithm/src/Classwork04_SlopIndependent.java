
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

public class Classwork04_SlopIndependent implements GLEventListener {

	static GLProfile profile = GLProfile.get(GLProfile.GL2);
	static GLCapabilities capabilities = new GLCapabilities(profile);
	// The canvas
	static GLCanvas glcanvas = new GLCanvas(capabilities);

	public static void main(String[] args) {
		// getting the capabilities object of GL2 profile

		Classwork04_SlopIndependent l = new Classwork04_SlopIndependent();
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

		double x1 = 1;
		double y1 = 2;
		double x2 = 6;
		double y2 = 9;

		// scaling
		x1 = x1 / 10;
		y1 = y1 / 10;
		x2 = x2 / 10;
		y2 = y2 / 10;

		double dx = (x2 - x1);
		double dy = (y2 - y1);

		// zone determine
		int zone = determineZone(dx, dy);
		System.out.println(x1 + " " + y1 + " " + x2 + " " + y2 + " " + dx + " "
				+ dy);
		System.out.println("Zone: " + zone);

		// next pixel
		if (zone == 1 || zone == 2 || zone == 5 || zone == 6) {
			double temp = x1;
			x1 = y1;
			y1 = temp;

			double temp2 = x2;
			x2 = y2;
			y2 = temp2;
		}
		dx = (x2 - x1);
		dy = (y2 - y1);

		System.out.println(x1 + " " + y1 + " " + x2 + " " + y2 + " " + dx + " "
				+ dy);

		double dInit = (2 * dy) - dx;
		double dNE = 2*(dy - dx);
		double dE = 2*dy;
		System.out.println(dInit + " " + dNE + " " + dE);

		while (x1 < x2) {
			if (dInit < 0) {
				dInit += dE;
			} else {
				dInit += dNE;
				y1 = y1 + 0.001;
			}
			x1 = x1 + 0.001;
			
			System.out.println("new zone: " + determineZone(dx, dy));
			//dx = (x2 - x1);
			//dy = (y2 - y1);
			//zone = determineZone(dx, dy);
			
			// line drawing
			//if (zone == 0) {
			gl.glColor3f(204f, 0f, 0f);
				gl.glVertex2d(x1, y1);

			//} else if (zone == 7) {
				gl.glColor3f(204f, 204f, 0f);
				gl.glVertex2d(x1, -y1);
				
			//} else if (zone == 3) {
				gl.glColor3f(204f, 204f, 204f);
				gl.glVertex2d(-x1, y1);
				
			//} else if (zone == 4) {
				gl.glColor3f(0f, 204f, 0f);
				gl.glVertex2d(-x1, -y1);
				
			//} else if (zone == 1) {
				gl.glColor3f(0f, 204f, 204f);
				gl.glVertex2d(y1, x1);
				
			//} else if (zone == 6) {
				gl.glColor3f(0f, 0f, 204f);
				gl.glVertex2d(y1, -x1);
				
			//} else if (zone == 2) {
				gl.glColor3f(204f, 0f, 204f);
				gl.glVertex2d(-y1, x1);
				
			//} else if (zone == 5) {
				gl.glColor3f(204f, 0f, 204f);
				gl.glVertex2d(-y1, -x1);
				
			//}
		}

		gl.glEnd();
	}

	public int determineZone(double dx, double dy) {
		if (Math.abs(dx) >= Math.abs(dy)) {// zone 0,7,3,4
			if (dx >= 0 && dy >= 0) {
				return 0;
			} else if (dx >= 0 && dy < 0) {
				return 7;
			} else if (dx < 0 && dy >= 0) {
				return 3;
			} else if (dx < 0 && dy < 0) {
				return 4;
			}
		} else {// zone 1,2 5,6
			if (dx >= 0 && dy >= 0) {
				return 1;
			} else if (dx >= 0 && dy < 0) {
				return 6;
			} else if (dx < 0 && dy >= 0) {
				return 2;
			} else if (dx < 0 && dy < 0) {
				return 5;
			}
		}

		return -1;
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