package PatternCommand.main;

import PatternCommand.concretecommand.CloseFileCommand;
import PatternCommand.concretecommand.OpenFileCommand;
import PatternCommand.concretecommand.WriteFileCommand;
import PatternCommand.invoker.FileInvoker;
import PatternCommand.invoker.FileSystemReceiverUtil;
import PatternCommand.receiver.FileSystemReceiver;

public class Main {

	public static void main(String[] args) {
		//Creating the receiver object
		FileSystemReceiver fs = FileSystemReceiverUtil.getUnderlyingFileSystem();
		
		//creating command and associating with receiver
		OpenFileCommand openFileCommand = new OpenFileCommand(fs);
		
		//Creating invoker and associating with Command
		FileInvoker file = new FileInvoker(openFileCommand);
		
		//perform action on invoker object
		file.execute();
		
		WriteFileCommand writeFileCommand = new WriteFileCommand(fs);
		file = new FileInvoker(writeFileCommand);
		file.execute();
		
		CloseFileCommand closeFileCommand = new CloseFileCommand(fs);
		file = new FileInvoker(closeFileCommand);
		file.execute();
	}

}
