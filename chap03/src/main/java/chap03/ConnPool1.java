package chap03;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class ConnPool1 implements InitializingBean, DisposableBean{

   public void afterPropertiesSet() throws Exception{
      System.out.println("ConnPool1.afterPropertiesSet()");
   }
   
   public void destroy() throws Exception{
      System.out.println("ConnPool1.destroy()");
   }
}