打包文件复制命令介绍。

	my.scala：根据提供的上线文档，把文档里面的对应的文件全部复制到指定的目录下。需要注意，文件需要绝对路径，文件后面添加-d选项。不能有其他无用的行。文件夹分隔符用//
			执行命令	D:\test>scala my.scala test.txt e://test 表示把D:\test目录下上线文档test.txt的内容指定的文件复制到e://test目录下。
			
	my2.scala: 根据提供的上线文档，把文档里面的对应的文件全部复制到指定的目录下。需要注意，文件需要相对路径，文件后面添加-d选项。不能有其他无用的行。文件夹分隔符用//
			执行命令	D:\test>scala my2.scala test2.txt e://test D://workspace//TBM//prov2 表示把D:\test目录下上线文档test.txt的内容指定的文件复制到e://test目录下 D://workspace//TBM//prov2 指定源文件夹
			
			
	my3.scala: 根据提供的上线文档，把文档里面的对应的文件的class文件全部复制到指定的目录下。需要注意，文件需要相对路径，文件后面添加-d选项。不能有其他无用的行。文件夹分隔符用//。需要去掉csrc目录
			执行命令	D:\test>scala my3.scala test3.txt e://test D:\workspace\TBM\prov2\WebRoot\WEB-INF\classes 表示把D:\test目录下上线文档test.txt的内容指定的文件复制到e://test目录下 D:\workspace\TBM\prov2\WebRoot\WEB-INF\classes 指定源文件夹
			
	my4.scala: 根据提供的上线文档，把文档里面的对应的文件的class文件全部复制到指定的目录下。需要注意，文件需要相对路径，不能有其他无用的行。/。需要去掉csrc目录,使用eclipse自带的copy qualified name 复制出路径即可
			执行命令	D:\test>scala my4.scala test4.txt e://test D:\workspace\TBM\prov2\WebRoot\WEB-INF\classes 表示把D:\test目录下上线文档test.txt的内容指定的文件复制到e://test目录下 D:\workspace\TBM\prov2\WebRoot\WEB-INF\classes 指定源文件夹
			
			