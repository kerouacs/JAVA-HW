import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
/** 
 *  I represent in the GenerateClass class  generate from the field variables a
 *  constructor, the setters, and the getters automatically just as Eclipse does.
 *  @author Ruopeng Jiang
 *  @version 2019-10-28
 */
public class GenerateClass {
    /** 
     *  Field variable for the name of the Class.
     */
	String classname;
    /** 
     *  Field variable for the name of the Variable.
     */
	String[] variableNames;
    /** 
     *  Field variable for the type of the Variable.
     */
	String[] variableTypes;
    /** 
     *  Constructor to set values to the field variables
     *  @param classname The name of the class.
     *  @param variableNames The name of the varible.
     *  @param variableTypes The type of the varible.
     */
	public GenerateClass(String classname, String[] variableNames, String[] variableTypes) {
		super();
		this.classname = classname;
		this.variableNames = variableNames;
		this.variableTypes = variableTypes;
	}
    /**
     *  Method to get a String with a declaration of the corresponding field variables.
     *  @return The declaration of the corresponding field variables.
     */
	public String makeFields() {
		int i = 0;
		String str = "";
		while (i<variableNames.length) {
			str +=  "  private " + variableTypes[i] +" " + variableNames[i] + ";" + "\n";
			i++;
		}
		return str+="\n";
	}
    /**
     *  Method to get a String with a corresponding constructor.
     *  @return The declaration of corresponding constructor.
     */
	public String makeConstructor() {
		int i = 0;int j=0;
		String str = "";
		if (variableNames.length<=0 || variableTypes.length<=0 ) {
			return "  public "  + classname+ "(){}\n";
		}
		else if(variableNames.length>0 && variableTypes.length>0){
			str +="  public "  + classname+ "("+variableTypes[i]+" "+variableNames[i];
			i++;
			while (i<variableNames.length) {
				str+=","+" "+variableTypes[i]+" "+variableNames[i];
				i++;		
			}
			str+="){\n";
			while ( j<variableNames.length) {
				str+= "    this."+variableNames[j]+" = "+variableNames[j]+";"+"\n";
				j++;
			}
		}
		return str+="  }\n";
	}
    /**
     *  Method to get a String with a with all getters in the order given by variableNames/variableTypes.
     *  @return The String with a with all getters in the order given by variableNames/variableTypes.
     */
	public String makeGetters() {
		String str = "";
		for(int i=0;i<variableNames.length;i++) {
			variableNames[i]= variableNames[i].substring(0,1).toUpperCase()+variableNames[i].substring(1);
			str += "  public "+variableTypes[i]+" get"+variableNames[i]+"(){\n";
			variableNames[i]= variableNames[i].substring(0,1).toLowerCase()+variableNames[i].substring(1);    
			str+="    return "+variableNames[i]+";\n"
					+"  }\n";
		}
		return str;
	}
    /**
     *  Method to get a String with a with all setters in the order given by variableNames/variableTypes.
     *  @return The String with a with all setters in the order given by variableNames/variableTypes.
     */
	public String makeSetters() {
		String str="";
		for(int i=0;i<variableNames.length;i++) {
			variableNames[i]= variableNames[i].substring(0,1).toUpperCase()+variableNames[i].substring(1);
			str +=  "  public void"+" set"+variableNames[i]+"("+variableTypes[i];
			variableNames[i]= variableNames[i].substring(0,1).toLowerCase()+variableNames[i].substring(1);
			str +=  " " +variableNames[i]+"){\n"
					+ "    this."+variableNames[i]+" = "+variableNames[i]+";\n"
					+"  }\n";
		}
		return str;
	}
    /**
     *  Method to  writes a rudimentary class, starting with the classname and the opening {, the field variables, 
     *  the constructor, the getters, the setters, and the closing }.
     */
	public void writeFile() {
		try { File file = new File(classname+".java"); 
		file.createNewFile();
		FileWriter writer = new FileWriter(file);
		writer.write("public class "+classname+"{\n"+makeFields()
				+makeConstructor()+makeGetters()+makeSetters()+"}");
		writer.close(); }catch(IOException e) {
			System.out.println("Something Wrong"); }
	}
}

