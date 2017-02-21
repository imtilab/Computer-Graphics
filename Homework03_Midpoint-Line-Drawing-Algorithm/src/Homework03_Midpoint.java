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

public class Homework03_Midpoint implements GLEventListener {

	static GLProfile profile = GLProfile.get(GLProfile.GL2);
	static GLCapabilities capabilities = new GLCapabilities(profile);
	// The canvas
	static GLCanvas glcanvas = new GLCanvas(capabilities);

	public static void main(String[] args) {
		// getting the capabilities object of GL2 profile

		Homework03_Midpoint l = new Homework03_Midpoint();
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

		File file = new File("coordinates.txt");//For Windows
		
		//File file = new File("/home/1320100021/Desktop/touhid-workspace/Lab03/coordinates");//For Linux
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
				// scaling
				x1 = x1 / 10;
				y1 = y1 / 10;
				x2 = x2 / 10;
				y2 = y2 / 10;

				double dx = (x2 - x1);
				double dy = (y2 - y1);

				// zone determine
				int zone = determineZone(dx, dy);
				System.out.println(x1 + " " + y1 + " " + x2 + " " + y2 + " "
						+ dx + " " + dy);
				System.out.println("Zone: " + zone);

				if (zone == 0) {//for zone 0, draw green lines
					double dInit = (2 * dy) - dx;
					double dNE = dy - dx;
					double dE = dy;
					System.out.println(dInit + " " + dNE + " " + dE);
					
					while (x1 < x2) {
						if (dInit < 0) {
							dInit += dE;
						} else {
							dInit += dNE;
							y1 = y1 + 0.001;
						}
						x1 = x1 + 0.001;

						gl.glColor3f(0f, 1f, 0f);
						gl.glVertex2d(x1, y1);
					}

				} else {//otherwise red lines using built in function glBegin(int arg) 
					gl.glColor3f(1f, 0f, 0f);

					// this geBegin() draws full line automatically
					//glBegin(int arg) takes how many line combinations to draw
					gl.glBegin(1);

					gl.glVertex2d(x1, y1);
					gl.glVertex2d(x2, y2);
					//gl.glEnd();
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//gl.glFlush();
		gl.glEnd();
	}

	// takes dx and dy, then return zone number
	public int determineZone(double dx, double dy) {
		if (Math.abs(dx) > Math.abs(dy)) {// zone 0,7,3,4
			if (dx > 0 && dy > 0) {
				return 0;
			} else if (dx > 0 && dy < 0) {
				return 7;
			} else if (dx < 0 && dy > 0) {
				return 3;
			} else if (dx < 0 && dy < 0) {
				return 4;
			}
		} else {// zone 1,2 5,6
			if (dx > 0 && dy > 0) {
				return 1;
			} else if (dx > 0 && dy < 0) {
				return 6;
			} else if (dx < 0 && dy > 0) {
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