/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.commands.Teleop; 

/** This subsystem handles matters relating to the movement of the robot **/ 
public class DriveTrain extends Subsystem {
  public DriveTrain(){
    // Delete constructor? 
  }
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  WPI_TalonSRX front_left  = new WPI_TalonSRX(1); // The number is the ID of the motor 
  WPI_TalonSRX front_right = new WPI_TalonSRX(2);
  // WPI_TalonSRX is an API instance that is the motor control object from ctr-electronics

  WPI_TalonSRX back_left   = new WPI_TalonSRX(3);
  WPI_TalonSRX back_right  = new WPI_TalonSRX(4);
  SpeedControllerGroup left = new SpeedControllerGroup(front_left, back_left);
  SpeedControllerGroup right = new SpeedControllerGroup(front_right, back_right);
  // SpeedControllerGroup is a way of grouping together microcontrollers. These groups can be told to run as a group of operations

  DifferentialDrive diffDrive = new DifferentialDrive(left, right);
  // DIfferentialDrive is a collection of motor controls used to drive. 

  // Method that drives the robot 
  public void drive(double x_axis, double y_axis) { 
    diffDrive.arcadeDrive​(x_axis, y_axis);
  }
  /* drive() is a method that takes in amounts to move by and moves the controls by those inputs */
  // arcadeDrive() is a method in the API that is one method of controlling motors, similar to that of an arcade joystick


  @Override
  public void initDefaultCommand() {
    setDefaultCommand(new Teleop()); // Makes a command the default command file linked to the subsystem. Teleop takes joystick input, so it is linked to the subsystem. Adds this to the scheduler
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
