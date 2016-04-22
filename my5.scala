import scala.io.Source
import java.io.File

if (args.length > 0) {
	for (line <- Source.fromFile(args(0)).getLines){
		if(line.trim().startsWith("--")){
			
		}else if(line.trim().startsWith("/WebRoot")){
			var from = args(2).trim().substring(0,args(2).trim().lastIndexOf("WebRoot")-1);
			println(from+"---")
			findFile(from,args(1),line)
		}else{
			findFile(args(2),args(1),line)	
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

def findFile(from: String ,to: String,line: String){
		var dir = new File(to+line.trim().substring(0,line.trim().lastIndexOf("/")).trim())
			if(dir.exists()){
				println("file is exists");
			}else{
				dir.mkdirs();
			}
			
			var sourceFileStr = from+line.trim().replace(".java",".class")
			copyFss(sourceFileStr,dir.getAbsolutePath())
			
			var sourceFile = new File(sourceFileStr);
			var sourceDir = sourceFile.getParentFile();
			var tempList = sourceDir.listFiles();
			for(temp <- tempList){
				if(temp.getName().startsWith(sourceFile.getName().trim().substring(0,sourceFile.getName().trim().lastIndexOf("."))) && !temp.getName().equals(sourceFile.getName)){
					copyFss(temp.getAbsolutePath(),dir.getAbsolutePath())
				}
			}
}