import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JProgressBar;
import javax.swing.JTextField;
import javax.xml.crypto.dsig.CanonicalizationMethod;

public class ProgressBarThread extends Thread {

	public boolean cancel = false;
	private JFrame jf;
	private JProgressBar jp;
	private JTextField ff;
	private JTextField tf;

	public ProgressBarThread(JFrame jf, JProgressBar jp, JTextField ff, JTextField tf) {
		// TODO Auto-generated constructor stub
		this.jf=jf;
		this.jp=jp;
		this.ff=ff;
		this.tf=tf;
	}
	
	BufferedInputStream in = null;
	BufferedOutputStream out = null;
	public void run() {
	try {
		File inFile = new File(ff.getText().trim());
		in = new BufferedInputStream(new FileInputStream(inFile));
		
		File outFile = new File(tf.getText().trim());
		out = new BufferedOutputStream(new FileOutputStream(outFile));
		
		int r=0;
		byte buffer[] = new byte[5];
		long filesize = in.available();
		long bytesread=0;
		jp.setValue(0);
		jp.setMaximum(100);
		while((r=in.read(buffer,0,buffer.length))!=-1)
		{
			out.write(buffer,0,r);
			bytesread+=r;
			int prg = (int) ((bytesread*100)/filesize);
			jp.setValue(prg);
			if(cancel)
				return;
		}
	}
	catch(FileNotFoundException e){
		System.out.println(e.getMessage());
	} 
	catch (IOException e) {
		// TODO Auto-generated catch block
		System.out.println(e.getMessage());
	}
	finally {
		try {
			in.close();
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	}
}
