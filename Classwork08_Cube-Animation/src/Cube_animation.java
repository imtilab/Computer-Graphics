import java.util.Random;
import javax.media.opengl.GL2;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLCapabilities;
import javax.media.opengl.GLEventListener;
import javax.media.opengl.GLProfile;
import javax.media.opengl.awt.GLCanvas;
import javax.swing.JFrame;

import com.jogamp.opengl.util.Animator;

public class Cube_animation implements GLEventListener {

	static GLProfile profile = GLProfile.get(GLProfile.GL2);
	static GLCapabilities capabilities = new GLCapabilities(profile);
	// The canvas
	static GLCanvas glcanvas = new GLCanvas(capabilities);
	
	//initializing angle
	double angle = 0.0;
	static Animator animator;
	
	public static void main(String[] args) {
		// getting the capabilities object of GL2 profile

		Cube_animation l = new Cube_animation();
		// creating frame
		GLProfile glp = GLProfile.getDefault();
		GLCapabilities caps = new GLCapabilities(glp);
		caps.setDoubleBuffered(true);
		GLCanvas canvas = new GLCanvas(caps);
		canvas.addGLEventListener(l);
		JFrame frame = new JFrame("Animating Cube");
		frame.setSize(600, 400);
		frame.add(canvas);
		frame.setVisible(true);
		canvas.addGLEventListener(new Cube_animation());

		animator = new Animator(canvas);
		// animator.add(canvas);
		animator.start();
	}
	//this method is called for infinite number of times
	public void display(GLAutoDrawable drawable) {
		angle += 5;
		
		System.out.println("Angle: " + angle);
		
		if (angle <=360) {	
			try {
				cubic_animation(drawable);

			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else{//stop animator loop
			animator.stop();
		}
	}
	
	//rotates and draws a new cube 
	public void cubic_animation(GLAutoDrawable drawable)
			throws InterruptedException {
		
		final GL2 gl = drawable.getGL().getGL2();

		// first cube

		// initializing coordinates
		double x1 = 0.0, y1 = 0.0, x2 = 0.5, y2 = 0.0, x3 = 0.0, y3 = 0.5, x4 = 0.5, y4 = 0.5;
		double x5 = 0.2, y5 = 0.3, x6 = 0.7, y6 = 0.3, x7 = 0.2, y7 = 0.8, x8 = 0.7, y8 = 0.8;

		gl.glClear(GL2.GL_COLOR_BUFFER_BIT);//clear the previous cube

		Thread.sleep(30);//delay time after each cube drawn

		// rotated coordinates
		double x11 = getRotatedX(angle, x1, y1);
		double y11 = getRotatedY(angle, x1, y1);

		double x12 = getRotatedX(angle, x2, y2);
		double y12 = getRotatedY(angle, x2, y2);

		double x13 = getRotatedX(angle, x3, y3);
		double y13 = getRotatedY(angle, x3, y3);

		double x14 = getRotatedX(angle, x4, y4);
		double y14 = getRotatedY(angle, x4, y4);

		double x15 = getRotatedX(angle, x5, y5);
		double y15 = getRotatedY(angle, x5, y5);

		double x16 = getRotatedX(angle, x6, y6);
		double y16 = getRotatedY(angle, x6, y6);

		double x17 = getRotatedX(angle, x7, y7);
		double y17 = getRotatedY(angle, x7, y7);

		double x18 = getRotatedX(angle, x8, y8);
		double y18 = getRotatedY(angle, x8, y8);

		// System.out.println(x11 + " " + y11);
		// System.out.println(x12 + " " + y12);
		// System.out.println(x13 + " " + y13);

		// new rotated cube
		gl.glColor3f(0f, 0f, 1f);
		// front
		drawLine(gl, x11, y11, x12, y12);
		drawLine(gl, x11, y11, x13, y13);
		drawLine(gl, x12, y12, x14, y14);
		drawLine(gl, x13, y13, x14, y14);
		// connect
		drawLine(gl, x11, y11, x15, y15);
		drawLine(gl, x12, y12, x16, y16);
		drawLine(gl, x13, y13, x17, y17);
		drawLine(gl, x14, y14, x18, y18);
		// back
		drawLine(gl, x15, y15, x16, y16);
		drawLine(gl, x15, y15, x17, y17);
		drawLine(gl, x16, y16, x18, y18);
		drawLine(gl, x17, y17, x18, y18);

		//gl.glFlush();
	}

	// take gl, x1, y1, x2, y2 and draw line using GL_LINES
	public void drawLine(GL2 gl, double x1, double y1, double x2, double y2) {
		gl.glBegin(GL2.GL_LINES);
		gl.glBegin(1);
		gl.glVertex2d(x1, y1);
		gl.glVertex2d(x2, y2);
		gl.glEnd();

	}

	// takes old x and y value, rotate it by angle degrees and then return rotated
	// x
	public double getRotatedX(double angle, double oldX, double oldY) {
		double newX = oldX * Math.cos(angle * (Math.PI / 180)) - oldY
				* Math.sin(angle * (Math.PI / 180));
		return newX;
	}

	// takes old x and y value, rotate it by angle degrees and then return rotated
	// y
	public double getRotatedY(double angle, double oldX, double oldY) {
		double newY = oldX * Math.sin(angle * (Math.PI / 180)) + oldY
				* Math.cos(angle * (Math.PI / 180));
		return newY;
	}

	public void dispose(GLAutoDrawable arg0) {
		// method body
	}

	public void init(GLAutoDrawable drawable) {
		drawable.getGL().setSwapInterval(1);
		// method body
		// 4. drive the display() in a loop
	}

	public void reshape(GLAutoDrawable arg0, int arg1, int arg2, int arg3,
			int arg4) {
		// method body
	}
	// end of main
}// end of classimport javax.media.opengl.GL2;