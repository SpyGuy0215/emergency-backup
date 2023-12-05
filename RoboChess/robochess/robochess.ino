#include <Servo.h>
#include <BraccioRobot.h>
#include <WiFiNINA.h>

int m1 = 0;
int m2 = 0;
int m3 = 0;
int m4 = 0;
int m5 = 0;
int m6 = 0;

Servo base; 
Servo shoulder;
Servo elbow;
Servo wrist_rot;
Servo wrist_ver;
Servo gripper;

Position restingPosition(25, 70, 170, 80, 120, 50);

char ssid[] = "ArcherA20_5G"; 
char pass[] = "jupiter30alien!";
int led = LED_BUILTIN; 


void setup(){

  Serial.begin(9600); 

  if (WiFi.status() == WL.NO_MODULE){
    Serial.println("Communication with WiFi module failed!")

    while(true);
  }

  while (status != WL_CONNECTED{
    Serial.print("Connecting to ")
    Serial.println(ssid)

    delay(10000);
  }

  Serial.println("Connected to network")

  BraccioRobot.setStartSpeed(30);
  BraccioRobot.init(restingPosition);

  delay(1000);
  BraccioRobot.powerOff();
}

void loop(){

}