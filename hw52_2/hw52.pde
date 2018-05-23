/* Alexia Leong
 APCS2 pd1
 HW52 -- Grow & Shrink
 2018-05-23 */

int clicked;
float width = 25;
float height = 25;

void setup() {
  size(800, 800);   //set dimensions of display window
  background(0);    //set background black
}

void draw() {
  if ((clicked%2) == 1 && clicked > 0) {    //if clicked odd times --> grow
    fill(255, 105, 180);  //set it pink    , fill circle w color
    ellipse(400, 400, width, height);   //put ellipse in center w dimensions
    width += .5;   //constant growth
    height += .5;
  } 
  if (clicked > 0 && (clicked % 2) == 0) {   //if clicked even times --> shrink
    clear();
    fill(255, 105, 180);  //set it pink
    ellipse(400, 400, width, height);    //have to make a new ellipse
    width -=.5;   //constant shrink(age)
    height -= .5;
  }
}

void mouseClicked() {
  clicked += 1;   //to keep track how many times mouse clicked
}
