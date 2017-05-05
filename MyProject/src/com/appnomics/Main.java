package com.appnomics;
/* Save this in a file called Main.java to compile and test it */

/* Do not add a package declaration */
import java.util.*;
import java.io.*;

/* You may add any imports here, if you wish, but only from the 
   standard library */


class Software implements Comparable<Software>{
	String name;
	Version version;
	
	
	public Software(String name, Version version) {
		super();
		this.name = name;
		this.version = version;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((version == null) ? 0 : version.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Software))
			return false;
		Software other = (Software) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (version == null) {
			if (other.version != null)
				return false;
		} else if (!version.equals(other.version))
			return false;
		return true;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Version getVersion() {
		return version;
	}
	public void setVersion(Version version) {
		this.version = version;
	}
	@Override
	public int compareTo(Software o) {

		return this.version.compareTo(o.version);
	
	}
}
/**
 * Version class defined with comparator for comparison and equals and hashcode for using in a key.
 * 
 * @author shivjite
 *
 */
class Version implements Comparable<Version>{
	int X;
	int Y;
	int Z;
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + X;
		result = prime * result + Y;
		result = prime * result + Z;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Version))
			return false;
		Version other = (Version) obj;
		if (X != other.X)
			return false;
		if (Y != other.Y)
			return false;
		if (Z != other.Z)
			return false;
		return true;
	}
	public Version(int x, int y, int z) {
		super();
		X = x;
		Y = y;
		Z = z;
	}
	public int getX() {
		return X;
	}
	public void setX(int x) {
		X = x;
	}
	public int getY() {
		return Y;
	}
	public void setY(int y) {
		Y = y;
	}
	public int getZ() {
		return Z;
	}
	public void setZ(int z) {
		Z = z;
	}

	@Override
	public int compareTo(Version o) {
		if(X>o.X){
			return 1;
		}
		else if(X==o.X){
			if(Y>o.Y){
				return 1;
			}
			else if(Y==o.Y){
				if(Z>o.Z){
					return 1;
				}
				else if(Z==o.Z){
					return 0;
				}
				else {
					return -1;
				}
			}
			else return -1;
		}
		else return -1;
		
		
	}
	
}

public class Main {
    public static int processData(ArrayList<String> array) {
    	//storing max version per software
    	Map<String,Version> maxVersion=new HashMap<String, Version>();
    	
    	//Storing software vise server count
    	Map<Software,Integer> softwareServerMap =new HashMap<Software,Integer>();
    	
    	int count=0;
    	// below loop only finds max version per software and maintains count for no of server per software
    	for(String line:array){
    		String server[]=line.split(",");
    		// Creating version object
    		Version v=new Version(Integer
					.parseInt(server[3].trim().split("\\.")[0]), Integer
					.parseInt(server[3].trim().split("\\.")[1]), server[3]
					.split("\\.").length < 3 ? 0 : Integer.parseInt(server[3]
					.split("\\.")[2]));
    		
    		Software s=new Software(server[2].trim(), v);
    		Version currMaxVersion=maxVersion.get(s.name);
    		int currSoftServerCount=softwareServerMap.get(s)==null?0:softwareServerMap.get(s);
    		
    		if(currMaxVersion==null){
    			currMaxVersion=v;
    			maxVersion.put(s.name, currMaxVersion);
    		}
    		else if(currMaxVersion.compareTo(v)==-1){
    			maxVersion.put(s.name, v);
    		}
    		
    		
    			softwareServerMap.put(s, currSoftServerCount+1);	
    		

    	}
    	
    	//getting number of out of date softwares which are present in atlease 2 servers
    	Iterator<Software> itr= softwareServerMap.keySet().iterator();
    	while(itr.hasNext()){
    		Software s=itr.next();
    		if(softwareServerMap.get(s)>1 && s.version.compareTo(maxVersion.get(s.name))==-1){
    			count+=1;
    		}
    	}
    	
    	return count;
       
    }

    public static void main (String[] args) {
        ArrayList<String> inputData = new ArrayList<String>();
        try {
            Scanner in = new Scanner(new BufferedReader(new FileReader("input.txt")));
            while(in.hasNextLine()) {
                String line = in.nextLine().trim();
                if (!line.isEmpty()) // Ignore blank lines
                    inputData.add(line);
            }
            int retVal = processData(inputData);
            PrintWriter output = new PrintWriter(new BufferedWriter(new FileWriter("output.txt")));
            output.println("" + retVal);
            output.close();
        } catch (IOException e) {
            System.out.println("IO error in input.txt or output.txt");
        }
    }
}
