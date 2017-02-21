# Classwork04_Slop-Independent-Line-Drawing-Algorithm


Write a program to implement the slope independent line drawing algorithm. 
Steps:

1. Generate coordinates for a line AB. A(x0,y0) and B(x1,y1)
2. Determine the zone of the line [0 … 7]
    a. If(|dx|>|dy|) [zones 0,7,3,4]
        i. If(dx>0 && dy>0)
           - Return Zone=0
ii.	Else if (?)
1.	Return zone=7
iii.	Else if (?)
1.	Return zone=3
iv.	Else 
1.	Return zone=4
b.	Else [zones 1,2,5,6
i.	If(?)
1.	Return Zone=1
ii.	Else if (?)
1.	Return zone=2
iii.	Else if (?)
1.	Return zone=5
iv.	Else 
1.	Return zone=6
3.	Calculate next pixel for zone 0
a.	If (zone 1|| 2||5||6)
i.	Swap (x0,y0)
ii.	Swap (x1,y1)
b.	Dinit=2dy-dx
c.	dNE=?
d.	dE=?
e.	Loop until (x0<x1)
i.	If(dinit<0)
1.	Dinit+=dE
ii.	Else 
1.	Dinit+=dNE
2.	Y++
iii.	X++
iv.	Convert back to correct zones coordinates ConvBack(x,y)

4.	ConvBack(x,y){ //each zone should have a different color
a.	If(zone==0)
      gl.glColor3f(1f,0f,0f);
i.	drawPixel(x,y)
b.	else if (zone==7)
i.	drawPixel(x,-y)
c.	else if(zone==3)
i.	drawPixel(?,?)
d.	else if(zone==4)
i.	drawPixel(?,?))
e.	else if(zone==1)
i.	drawPixel(?,?)
f.	else if(zone==2)
i.	drawPixel(?,?)
g.	else if(zone==3)
i.	drawPixel(?,?)
h.	else if(zone==4)
i.	drawPixel(?,?)


}
gl.glColor3f(1f,0f,0f); //gives us red
gl.glColor3f(0f,1f,0f); //gives us green
gl.glColor3f(0f,0f,1f); //gives us blue





----------------
Requirements: 

You must configure your IDE for graphics project.

See here https://github.com/imtilab/jogamp-all-platforms how to set up JOGL in Eclipse for Graphics projects
