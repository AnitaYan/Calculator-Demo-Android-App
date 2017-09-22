package cn.edu.hdu.calculatord;


import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends Activity implements OnClickListener{

	 Button btn0;
	 Button btn1;
	 Button btn2;
	 Button btn3;
	 Button btn4;
	 Button btn5;
	 Button btn6;
	 Button btn7;
	 Button btn8;
	 Button btn9;
	 Button btndot;
	 Button btnAC;
	 Button btnDel;
	 Button btnPlu;
	 Button btnMin;
	 Button btnMul;
	 Button btnDiv;
	 Button btnHex;
	 Button btnEqu;
	 EditText editText1;
	 boolean clear_flag;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		 btn0 = (Button)findViewById(R.id.btn0);
	     btn1 = (Button)findViewById(R.id.btn1);
	     btn2 = (Button)findViewById(R.id.btn2);
	     btn3 = (Button)findViewById(R.id.btn3);
	     btn4 = (Button)findViewById(R.id.btn4);
	     btn5 = (Button)findViewById(R.id.btn5);
	     btn6 = (Button)findViewById(R.id.btn6);
	     btn7 = (Button)findViewById(R.id.btn7);
	     btn8 = (Button)findViewById(R.id.btn8);
	     btn9 = (Button)findViewById(R.id.btn9);
	     btndot = (Button)findViewById(R.id.btndot);
	     
	     btnDel = (Button)findViewById(R.id.btnDel);
	     btnAC = (Button)findViewById(R.id.btnAC);
	     btnHex = (Button)findViewById(R.id.btnHex);
	     btnPlu = (Button)findViewById(R.id.btnPlu);
	     btnMin = (Button)findViewById(R.id.btnMin);
	     btnMul = (Button)findViewById(R.id.btnMul);
	     btnDiv = (Button)findViewById(R.id.btnDiv);
	     btnEqu = (Button)findViewById(R.id.btnEqu);
	     editText1 = (EditText)findViewById(R.id.editView1);
	     
	     btnDel.setOnClickListener(this);
	     btnAC.setOnClickListener(this);
	     btnHex.setOnClickListener(this);
	     btnPlu.setOnClickListener(this);
	     btnMin.setOnClickListener(this);
	     btnMul.setOnClickListener(this);
	     btnDiv.setOnClickListener(this);
	     btnEqu.setOnClickListener(this);
	     btn0.setOnClickListener(this);
	     btn1.setOnClickListener(this);
	     btn2.setOnClickListener(this);
	     btn3.setOnClickListener(this);
	     btn4.setOnClickListener(this);
	     btn5.setOnClickListener(this);
	     btn6.setOnClickListener(this);
	     btn7.setOnClickListener(this);
	     btn8.setOnClickListener(this);
	     btn9.setOnClickListener(this);
	     btndot.setOnClickListener(this);
	   
	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		String str = editText1.getText().toString();
		switch(arg0.getId()){
		case R.id.btn0:
 		case R.id.btn1:
 		case R.id.btn2:
 		case R.id.btn3:
 		case R.id.btn4:
 		case R.id.btn5:
 		case R.id.btn6:
 		case R.id.btn7:
 		case R.id.btn8:
 		case R.id.btn9:
 		case R.id.btndot:
 			if(clear_flag){
 				clear_flag=false;
 				str="";
 				editText1.setText("");;
 			}
 			editText1.setText(str + ((Button) arg0).getText());
 			break;
 		case R.id.btnPlu:
 		case R.id.btnMin:
 		case R.id.btnMul:
 		case R.id.btnDiv:
 			if(clear_flag){
 				clear_flag=false;
 				str="";
 				editText1.setText("");
 			}
 			editText1.setText(str +" "+((Button) arg0).getText()+" ");
 			break;
 		case R.id.btnAC:
			clear_flag=false;
 			editText1.setText("");
 			break;
 		case R.id.btnDel:
 			if(clear_flag){
 				clear_flag=false;
 				str="";
 				editText1.setText("");
			}else if(str!=null&&!str.equals("")){
 				editText1.setText(str.substring(0,str.length()-1));
 			}
 			break;
 		case R.id.btnEqu:
 			if(clear_flag){
 				clear_flag=false;
 				str="";
 				editText1.setText("");
			}
 			getResult();
 			break;
 		case R.id.btnHex:
 			Integer num = Integer.parseInt(str);
 			editText1.setText(Integer.toHexString(num));
 			break;
		}
	}
	
	private void getResult(){
		
		String exp = editText1.getText().toString();
		if(exp==null||exp.equals("")){
			return;
		}
		if(!exp.contains("")){
			return;
		}
		if(clear_flag){
			clear_flag=false;
			
		}
		clear_flag=true;
		double result=0;
	    int space = exp.indexOf(' ');
        String s1 = exp.substring(0, space);
        String op = exp.substring(space + 1, space + 2);
        String s2 = exp.substring(space + 3);
		if(!s1.equals("")&&!s2.equals("")){
			double d1=Double.parseDouble(s1);
			double d2=Double.parseDouble(s2);
			if(op.equals("£«")){
				result=d1+d2;
			}else if(op.equals("-")){
				result=d1-d2;
			}else if(op.equals("¡Á")){
				result=d1*d2;
			}else if(op.equals("¡Â")){
				if(d2==0){
					result=0;
				}else{
				result=d1/d2;
				}
			}
			if(!s1.contains(".")&&!s2.contains(".")&&!op.equals("¡Â")){
				int r=(int) result;
				editText1.setText(r+"");
			}else{
				editText1.setText(result+"");
			}
		}else if(!s1.equals("")&&s2.equals("")){
			
			editText1.setText(exp);	
		}else if(s1.equals("")&&!s2.equals("")){
			double d2=Double.parseDouble(s2);
			
			if(op.equals("£«")){
				result=0+d2;
			}else if(op.equals("-")){
				result=0-d2;
			}else if(op.equals("¡Á")){
				result=0;
			}else if(op.equals("¡Â")){
				result=0;
			}
			if(!s2.equals(".")){
				int r=(int)result;
				editText1.setText(r+"");	
			}else{
				editText1.setText(result+"");
			}
		}else{
			editText1.setText("");
		}
		
	}
	
}
