snake player;
food snakeFood;
int highScore;

void setup(){
  size(700, 700);
  frameRate(15);
  player = new snake();
  snakeFood = new food();
  rectMode(CENTER);
  textAlign(CENTER, CENTER);
  
  highScore = 0;
}



void draw(){
  background(#9CCC00);
  drawScoreboard();
  
  player.move();
  player.display();
  snakeFood.display();
  
  
  if( dist(snakeFood.xpos, snakeFood.ypos, player.xpos.get(0), player.ypos.get(0)) < player.sidelen ){
    snakeFood.reset();
    player.addLink();
  }
  
  if(player.len > highScore){
    highScore= player.len;
  }
}


void keyPressed(){
  if(key == CODED){
    if(keyCode == LEFT){
      player.dir = "left";
    }
    if(keyCode == RIGHT){
      player.dir = "right";
    }
    if(keyCode == UP){
      player.dir = "up";
    }
    if(keyCode == DOWN){
      player.dir = "down";
    }
  }
}


void drawScoreboard(){
  // All of the scode for code and title
  

  
  
  
  
  
  // draw scoreboard
  
  fill(0, 0, 255);
  textSize(17);
  text( "Score: " + player.len, 320, 50);
  
 
}
