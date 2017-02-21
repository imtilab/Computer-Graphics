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

public class Classwork02_DDA implements GLEventListener {

	static GLProfile profile = GLProfile.get(GLProfile.GL2);
	static GLCapabilities capabilities = new GLCapabilities(profile);
	// The canvas
	static GLCanvas glcanvas = new GLCanvas(capabilities);

	public static void main(String[] args) {
		// getting the capabilities object of GL2 profile

		Classwork02_DDA l = new Classwork02_DDA();
		// creating frame
		glcanvas.addGLEventListener(l);
		glcanvas.setSize(600, 400);

		final JFrame frame = new JFrame("straight Line");
		// adding canvas to frame
		frame.getContentPane().add(glcanvas);
		frame.setSize(frame.getContentPane().getPreferredSize());
		frame.setVisible(true);

	}

	// you are to work in this method
	public void display(GLAutoDrawable drawable) {
		final GL2 gl = drawable.getGL().getGL2();
		gl.glBegin(GL2.GL_POINTS);// static field

		// --------your code start from here---------------

		File file = new File("coordinates.txt");

		try {
			Scanner sc = new Scanner(file);

			while (sc.hasNextLine()) {
				String str = sc.nextLine();
				StringTokenizer st = new StringTokenizer(str, " ");

				int c = 0;
				double x1 = 0.0;
				double y1 = 0.0;
				double x2 = 0.0;
				double y2 = 0.0;

				while (st.hasMoreTokens()) {
					if (c == 0) {
						x1 = Double.parseDouble(st.nextToken());
					} else if (c == 1) {
						y1 = Double.parseDouble(st.nextToken());
					} else if (c == 2) {
						x2 = Double.parseDouble(st.nextToken());
					} else if (c == 3) {
						y2 = Double.parseDouble(st.nextToken());
					}
					c++;
				}

				// System.out.println(x1 + " " + y1 + " " + x2 + " " + y2);

				double m = (y2 - y1) / (x2 - x1);
				System.out.println("Slope m: " + m);

				if (x1 > x2) {// swap points, we draw left to right
					Double p = x1;
					Double q = y1;
					x1 = x2;
					y1 = y2;
					x2 = p;
					y2 = q;
				}

				// scaling
				x1 = x1 / 10;
				y1 = y1 / 10;
				x2 = x2 / 10;
				y2 = y2 / 10;
				Double mScale = m / 1000;
				
				for (; x1 <= x2;) {
					// System.out.println(x1 + " " + y1 + " " + x2 + " " + y2 +
					// " " + mScale);
					gl.glVertex2d(x1, y1);

					if (-1 < mScale && mScale < 1) {
						x1 = x1 + 0.001;
						y1 = y1 + mScale;
					} else {
						y1 = y1 + 0.001;
						x1 = x1 + (1 / mScale);
					}
				}

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