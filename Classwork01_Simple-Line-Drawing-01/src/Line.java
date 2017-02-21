import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
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

public class Line implements GLEventListener {

	static GLProfile profile = GLProfile.get(GLProfile.GL2);
	static GLCapabilities capabilities = new GLCapabilities(profile);
	// The canvas
	static GLCanvas glcanvas = new GLCanvas(capabilities);

	public static void main(String[] args) {
		// getting the capabilities object of GL2 profile
		Line l = new Line();
		// creating frame
		glcanvas.addGLEventListener(l);
		glcanvas.setSize(600, 400);

		final JFrame frame = new JFrame("straight Line");
		// adding canvas to frame
		frame.getContentPane().add(glcanvas);
		frame.setSize(frame.getContentPane().getPreferredSize());
		frame.setVisible(true);

	}
	
	//change this method only
	public void display(GLAutoDrawable drawable) {
		final GL2 gl = drawable.getGL().getGL2();
		gl.glBegin(GL2.GL_POINTS);// static field

		//--------your code start from here---------------
		
		
		// manual input to draw lines
		gl.glVertex2d(0.0f, 0.0f);
		gl.glVertex2d(0.0f, 0.3f);
		gl.glVertex2d(0.0f, -0.3f);
		gl.glVertex2d(0.0f, 0.2f);
		gl.glVertex2d(0.0f, -0.2f);
		gl.glVertex2d(0.0f, -0.4f);
		gl.glVertex2d(0.0f, 0.1f);
		gl.glVertex2d(0.0f, -0.1f);
		gl.glVertex2d(0.0f, -0.5f);
		gl.glVertex2d(0.3f, 0.3f);
		gl.glVertex2d(0.1f, 0.3f);
		gl.glVertex2d(-0.1f, 0.3f);
		gl.glVertex2d(-0.3f, 0.3f);
		gl.glVertex2d(0.5f, 0.3);
		gl.glVertex2d(0.5f, 0.1f);
		gl.glVertex2d(0.5f, -0.1f);
		gl.glVertex2d(0.5f, -0.3f);
		gl.glVertex2d(0.5f, -0.5f);
		gl.glVertex2d(-0.5f, 0.3f);
		gl.glVertex2d(-0.5f, -0.5f);
		gl.glVertex2d(-0.5f, 0.3f);
		gl.glVertex2d(-0.5f, 0.1f);
		gl.glVertex2d(-0.5f, -0.1f);
		gl.glVertex2d(-0.5f, -0.3f);
		gl.glVertex2d(-0.3f, -0.5f);
		gl.glVertex2d(-0.1f, -0.5f);
		gl.glVertex2d(0.1f, -0.5f);
		gl.glVertex2d(0.3f, -0.5f);

		// draw line using loop
		for (float i = .45f; i < .90f; i += 0.05f) {
			gl.glVertex2d(i, i);
		}

		// draw line using loop (hard coding way)
		int j = 44;
		for (int i = 50; i < 90; i += 5) {
			gl.glVertex2d(Double.parseDouble("0." + i + "f"),
					Double.parseDouble("0." + j + "f"));
		}

		// draw lines using file input
		File file = new File("coordinates.txt");
		try {
			Scanner sc = new Scanner(file);
			while (sc.hasNextLine()) {
				double a = Double.parseDouble(sc.nextLine());
				double b = Double.parseDouble(sc.nextLine());
				gl.glVertex2d(a, b);
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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