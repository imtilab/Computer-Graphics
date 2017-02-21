import javax.media.opengl.GL2;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLCapabilities;
import javax.media.opengl.GLEventListener;
import javax.media.opengl.GLProfile;
import javax.media.opengl.awt.GLCanvas;
import javax.swing.JFrame;

public class Circle implements GLEventListener {

	static GLProfile profile = GLProfile.get(GLProfile.GL2);
	static GLCapabilities capabilities = new GLCapabilities(profile);
	// The canvas
	static GLCanvas glcanvas = new GLCanvas(capabilities);

	public static void main(String[] args) {
		// getting the capabilities object of GL2 profile

		Circle l = new Circle();
		// creating frame
		glcanvas.addGLEventListener(l);
		glcanvas.setSize(600, 600);

		final JFrame frame = new JFrame("straight Line");
		// adding canvas to frame
		frame.getContentPane().add(glcanvas);
		frame.setSize(frame.getContentPane().getPreferredSize());
		frame.setVisible(true);

	}

	public void display(GLAutoDrawable drawable) {
		final GL2 gl = drawable.getGL().getGL2();
		gl.glBegin(GL2.GL_POINTS);// static field
	
		// input
		double r = 0.7;
		// initializing 
		double x = 0.0, y = r;
		
		drawPoints(gl, x, y);//draw first point
		
		double p = (5 / 4) - r;

		while (x <= y) {
			if (p < 0) {//midpoint is inside the circle
				p += (2 * x) + 0.001;     
			} else {//midpoint outside the circle
				p += -(2 * y) + (2 * x) + 0.001;
				y=y-0.001;
			}
			x=x+0.001;
			
			drawPoints(gl, x, y);
		}
		
		gl.glEnd();
	}
	
	//take gl, x and y. then draw points in 8 way sym
	public void drawPoints(GL2 gl, double x, double y) {
		gl.glVertex2d(x, y);//zone 0
		
		gl.glColor3f(204f, 0f, 0f);
		gl.glVertex2d(x, -y);//zone 7

		gl.glColor3f(204f, 204f, 0f);
		gl.glVertex2d(-x, y);//zone 3

		gl.glColor3f(204f, 204f, 204f);
		gl.glVertex2d(-x, -y);//zone 4

		gl.glColor3f(0f, 204f, 0f);
		gl.glVertex2d(y, x);//zone 1

		gl.glColor3f(0f, 204f, 204f);
		gl.glVertex2d(y, -x);//zone 6

		gl.glColor3f(0f, 0f, 204f);
		gl.glVertex2d(-y, x);//zone 2

		gl.glColor3f(204f, 0f, 204f);
		gl.glVertex2d(-y, -x);//zone 5

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