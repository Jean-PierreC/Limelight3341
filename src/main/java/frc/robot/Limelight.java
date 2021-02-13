// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
/** Add your docs here. */
public class Limelight {
    private  static NetworkTable table;
	private  static NetworkTableEntry tv, tx, ty, ta;
	private  static int pipeline = 0;
	private  static int v;
	private  static double x, y, area;
	private  static double targetArea;
	private  static double ballheight = 3.5; //inches
    private  static double cameraheight = 10.5; //inches
    private static double distance;
    
    static{
    table = NetworkTableInstance.getDefault().getTable("limelight");
	tv = table.getEntry("tv");
	tx = table.getEntry("tx");
	ty = table.getEntry("ty");
	ta = table.getEntry("ta");
    }
    
    public static void update() {
		table.getEntry("pipeline").setNumber(pipeline);
		table.getEntry("ledMode").setNumber(0);
		v = (int) tv.getDouble(0.0);
		x = tx.getDouble(0.0);
		y = ty.getDouble(0.0);
		area = ta.getDouble(0.0);

		SmartDashboard.putNumber("x", x);
		SmartDashboard.putNumber("y", y);
		SmartDashboard.putNumber("area", area);
		SmartDashboard.putBoolean("v", v == 1 ? true : false);
    }

    public static void disable() {
		table.getEntry("pipeline").setNumber(0);
	}

	public static void setPipeline(int num) {
		if (num >= 0 && num <= 9) {
			pipeline = num;
			
		}
	}

	public static int getV() {
		return v;
	}
	public static double getX() {
		return x;
	}
	public static double getY() {
		return y;
	}
	public static double getArea() {
		return area;
	}

    public double getDistance(){
        
         distance=(43.3*Math.pow(area, -.531));
         System.out.println(area);
        // System.out.println("distance: "+distance);
         return distance;
	}
}
