/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxcommoncolor;

import java.util.Scanner;

/**
 *
 * @author chaz
 */
public class CommandLineArgs {
    private final String[] args;
    private String filepath;
    private boolean reportAverage;
    private boolean colorOnly;
    private int coarseness;
    
    
    
    
    //Constructor
    //--------------------------------------------------------------------------
    public CommandLineArgs(String[] args){
        this.args = args;
    }
    //Getters and setters
    //--------------------------------------------------------------------------
    public int coarseness(){
        return this.coarseness;
    }
    public boolean reportAverage(){
        return this.reportAverage;
    }
    public boolean colorOnly(){
        return this.colorOnly;
    }
    public String filepath(){
        return this.filepath;
    }
    //--------------------------------------------------------------------------
    
    /**
     *
     */
    public void set(){
        
        if(args.length == 0 || args.length > 3){
            failedToStart();    //incorrect number of arguments
        }
        
        if(args.length == 1 && args[0].equals("help") || args[0].equals("?")){
            failedToStart();    //Provide usage and exit if help requested
        }
        
        
        
        if(args.length == 2){
            if(args[1].equals("-avg")){ //Verbose. Output average RGB values
                reportAverage=true;
            }
        }
        
        if(args.length == 3){
            if(args[1].equals("-col")){ //Color only
                colorOnly = true;
                coarseness = Integer.parseInt(args[2]); //Will receive the coarseness from the command line
            }else if(args[1].equals("-avg")){
                reportAverage=true;
                coarseness = Integer.parseInt(args[2]);
            }
        }
        
        this.filepath = args[0];
            
        if(!colorOnly){ //If color only wasn't selected, ask for coarseness
            promptCoarseness();
        }
    }
    
    public static void failedToStart(){
        System.out.println("\nUsage: java MostCommonColor <filename> [-avg]OR[-col x] where x is the level of coarseness\n");
        System.exit(1);
    }
    
    private void promptCoarseness(){
        int tempCoarseness;
        tempCoarseness = 3;
        Scanner scan = new Scanner(System.in);
            System.out.println("How coarse? Enter an integer value. Every nth row/column will be checked. 1 is pixel perfect, 2 will check 25% of pixels, etc.");
            try{tempCoarseness = scan.nextInt();
            }catch(Exception e){
                System.out.println("Integer not found. Defaulting to coarseness of 3");
            }finally{
                scan.close();
            }
            this.coarseness = tempCoarseness;
    }
}