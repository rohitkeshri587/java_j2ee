import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JProgressBar;
import javax.swing.JTextField;

public class ProgressBarApp implements ActionListener {
	
	JFrame jf = new JFrame("Progress Bar App");
	JProgressBar jp = new JProgressBar();
	JTextField ff = new JTextField();
	JTextField tf = new JTextField();
	JButton cp = new JButton("Copy");
	JButton cn = new JButton("Cancel");
	ProgressBarThread thread;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ProgressBarApp pba = new ProgressBarApp();
	}

	public ProgressBarApp() {
		// TODO Auto-generated constructor stub
		jf.setLayout(null);
		jf.setSize(400, 400);
		
		jp.setStringPainted(true);
		
		jp.setBounds(10, 10, 360, 40);
		ff.setBounds(10, 60, 120, 30);
		tf.setBounds(10, 110, 120, 30);
		cp.setBounds(60, 180, 120, 30);
		cn.setBounds(180, 180, 120, 30);
		
		jf.add(jp);
		jf.add(ff);
		jf.add(tf);
		jf.add(cp);
		jf.add(cn);
		
		cp.addActionListener(this);
		cn.addActionListener(this);
		cn.setEnabled(false);
		jf.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==cp)
		{
			thread = new ProgressBarThread(jf, jp, ff, tf);
			thread.start();
			cp.setEnabled(false);
			cn.setEnabled(true);
		}
		if(e.getSource()==cn)
		{
			thread.cancel = true;
			cn.setEnabled(false);
		}
		
	}

}
