import scala.io.Source
import java.io.File

if (args.length > 0) {
	var lineDir : String = ""
	var lineDirTarget : String = ""
	for (line <- Source.fromFile(args(0)).getLines){
		if(line.trim().startsWith("--")){
			
		}else if(line.trim().endsWith("-d")){
			var dir = new File(args(1)+line.trim().substring(0,line.trim().lastIndexOf("-d")-1).trim())
			println(args(1)+line.trim().substring(0,line.trim().lastIndexOf("-d")-1).trim())
			if(dir.exists()){
				println("file is exists");
			}else{
				dir.mkdirs();
			}
			lineDir = line
			lineDirTarget = args(1)+line.trim().substring(0,line.trim().lastIndexOf("-d")-1).trim()
		}else{
			
			var sourceFileStr = args(2)+lineDir.trim().substring(0,lineDir.trim().lastIndexOf("-d")-1).trim()+line.trim()
			copyFss(sourceFileStr,lineDirTarget)
			
			var sourceFile = new File(sourceFileStr);
			var sourceDir = sourceFile.getParentFile();
			var tempList = sourceDir.listFiles();
			for(temp <- tempList){
				if(temp.getName().startsWith(line.trim().substring(0,line.trim().lastIndexOf(".")-1))){
					copyFss(args(2)+lineDir.trim().substring(0,lineDir.trim().lastIndexOf("-d")-1).trim()+temp.getName(),lineDirTarget)
				}
			}
			
		}
	}
}  
else  
 Console.err.println("Please enter filename") 
 
def copyFss(from: String,to: String){
	var rt = Runtime.getRuntime();
	var p = rt.exec("cmd.exe /c copy "+from.replace('/','\\')+" "+to.replace('/','\\'));
	// var p = rt.exec("cmd.exe /k ipconfig /all");
	if(p != null){
		p = null;
	}
}