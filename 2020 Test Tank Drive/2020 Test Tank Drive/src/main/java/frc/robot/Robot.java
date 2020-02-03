/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;


import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.cscore.UsbCamera;
/**
 * This is a demo program showing the use of the RobotDrive class, specifically
 * it contains the code necessary to operate a robot with tank drive.
 */
public class Robot extends TimedRobot {
  private DifferentialDrive m_myRobot;
  private Joystick m_leftStick;
  private Joystick m_rightStick;

  @Override
  public void robotInit() {
    m_myRobot = new DifferentialDrive(new Spark(1), new Spark(0));
    m_leftStick = new Joystick(0);
    m_rightStick = new Joystick(1);
    UsbCamera cam0 = CameraServer.getInstance().startAutomaticCapture();
      cam0.setFPS(30);
      cam0.setResolution(240, 320);
   // UsbCamera cam1 = CameraServer.getInstance().startAutomaticCapture();
     // cam1.setFPS(30);
      //cam1.setResolution(240, 320);
  }

  @Override
  public void teleopPeriodic() {
    m_myRobot.tankDrive(m_leftStick.getY()*-.5, m_rightStick.getY()*-.5);
  }
}
45