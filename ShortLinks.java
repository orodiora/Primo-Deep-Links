package com.exlibris.primo.utils;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.regex.*;

import com.exlibris.primo.interfaces.PushToInterface;
import com.exlibris.primo.srvinterface.RecordDocDTO;
import com.exlibris.primo.srvinterface.PnxConstants;
import com.exlibris.primo.xsd.commonData.PrimoResult;


public class ShortLinks implements PushToInterface{

        protected RecordDocDTO[] searchResultFullDoc;

        public String pushTo(HttpServletRequest request, HttpServletResponse response,PrimoResult[] record,boolean fromBasket) throws Exception {

            int i;
            int j;


                  response.setContentType("text/html");
                  PrintWriter out = response.getWriter();
                  out.println("<html>");
                  out.println("<script language=\"JavaScript\">");
                  out.println("<!--");
                  out.println("{window.resizeTo(800,220)}");
                  out.println("-->");
                  out.println("</script>"); 
                  out.println("<head>");
                  out.println("<style>");
		    out.println("body {background-color: #ffffff; color: #32322f;margin: 0px; padding: 0px; font-family: 'Arial Unicode MS',Arial,verdana,serif;font-size: 100%;}");
	           out.println("h2 {float: left;width:100%; padding: 0.3em 0; color:#606f7f;}");
                  out.println("th {color: #8c8d8c; font-weight: bold; font-size: 120%; white-space: nowrap;}");
                  out.println("select {color: black; font-size: 90%; white-space: nowrap;font-family: 'Arial Unicode MS',Arial,verdana,serif;}");
                  out.println("input {color: black; font-size: 90%; white-space: nowrap;font-family: 'Arial Unicode MS',Arial,verdana,serif;}");
                  out.println("</style>");
                  out.println("<title>Search Shortcut</title>");
                  out.println("</head>");
                  out.println("<body>");

		searchResultFullDoc = new RecordDocDTO[record.length];
		searchResultFullDoc[record.length-1] = new RecordDocDTO(request ,record[record.length-1],0);
			  
		String[] _doc=(String[])searchResultFullDoc[record.length-1].getValuesNoHL().get(PnxConstants.CONTROL_RECORDID);

		String currentURL = null;
		String pcID = null;
		pcID = (String)request.getParameter("doc");	

		if( request.getAttribute("javax.servlet.forward.request_uri") != null ){
		    currentURL = (String)request.getAttribute("javax.servlet.forward.request_uri");
		}
		if( currentURL != null && request.getAttribute("javax.servlet.include.query_string") != null ){
		    currentURL += "?" + request.getQueryString();
		}

		Pattern p1 = Pattern.compile("dedupmrg");
		Pattern p2 = Pattern.compile("61MONASH_AU");
		Pattern p3 = Pattern.compile("catmsa");
		Pattern p4 = Pattern.compile("catmum");
		Pattern p5 = Pattern.compile("monarrow");
		Pattern p6 = Pattern.compile("catrare");
		Pattern p7 = Pattern.compile("catcarm");
		Pattern p8 = Pattern.compile("TN");

		Matcher m1 = p1.matcher(_doc[0]);
		Matcher m2 = p2.matcher(_doc[0]);
		Matcher m3 = p3.matcher(_doc[0]);
		Matcher m4 = p4.matcher(_doc[0]);
		Matcher m5 = p5.matcher(_doc[0]);
		Matcher m6 = p6.matcher(_doc[0]);
		Matcher m7 = p7.matcher(_doc[0]);
		Matcher m8 = p8.matcher(_doc[0]);

		boolean r1 = m1.find();
		boolean r2 = m2.find();
		boolean r3 = m3.find();
		boolean r4 = m4.find();
		boolean r5 = m5.find();
		boolean r6 = m6.find();
		boolean r7 = m7.find();
		boolean r8 = m8.find();

		if (r1){
		   // Dedup record
	          out.println("Copy this URL: (Dedup'd Record'");
	          out.println("<br/><br/>");
  	          out.println("<a href='http://search.lib.monash.edu/primo_library/libweb/action/dlDisplay.do?vid=MUL_ALMA&displayMode=full&docId=" + _doc[0] + "'>http://search.lib.monash.edu/primo_library/libweb/action/dlDisplay.do?vid=MUL_ALMA&displayMode=full&docId=" + _doc[0] + "</a>"); 
		} else {
			if (r2) {
			// 61MONASH_AU record - Australia
	       	   out.println("Copy this URL: (Australia copy)");
	       	   out.println("<br/><br/>");
  	       	   out.println("<a href='http://search.lib.monash.edu/primo_library/libweb/action/dlDisplay.do?vid=MUL_ALMA&displayMode=full&docId=" + _doc[0] + "'>http://search.lib.monash.edu/primo_library/libweb/action/dlDisplay.do?vid=MUL_ALMA&displayMode=full&docId=" + _doc[0] + "</a>"); 
			} else {
			   if (r3){
				//Catmsa record - South Africa
	       		out.println("Copy this URL: (South Africa copy)");
	       		out.println("<br/><br/>");
  	       		out.println("<a href='http://search.lib.monash.edu/primo_library/libweb/action/dlDisplay.do?vid=MUM_MSA&displayMode=full&docId=" + _doc[0] + "'>http://search.lib.monash.edu/primo_library/libweb/action/dlDisplay.do?vid=MUM_MSA&displayMode=full&docId=" + _doc[0] + "</a>"); 
			   } else {
			       if (r4){
				    //Catmum record - Malaysia
	       		    out.println("Copy this URL: (Malaysia copy)");
	       		    out.println("<br/><br/>");
  	       		    out.println("<a href='http://search.lib.monash.edu/primo_library/libweb/action/dlDisplay.do?vid=MUM_MSA&displayMode=full&docId=" + _doc[0] + "'>http://search.lib.monash.edu/primo_library/libweb/action/dlDisplay.do?vid=MUM_MSA&displayMode=full&docId=" + _doc[0] + "</a>"); 
			       } else {
    				    if (r5){
				       //Catmum record - Monash University Research Repository
	       		       out.println("Copy this URL: (Monash University Research Repository copy)");
	       		       out.println("<br/><br/>");
  	       		       out.println("<a href='http://search.lib.monash.edu/primo_library/libweb/action/dlDisplay.do?vid=MUL_ALMA&displayMode=full&docId=" + _doc[0] + "'>http://search.lib.monash.edu/primo_library/libweb/action/dlDisplay.do?vid=MUL_ALMA&displayMode=full&docId=" + _doc[0] + "</a>"); 
			           } else {
	   				   if (r6){
				       	//Catmum record - Rare books
	       		       	out.println("Copy this URL: (Rare Books Collection copy)");
	       		       	out.println("<br/><br/>");
  	       		       	out.println("<a href='http://search.lib.monash.edu/primo_library/libweb/action/dlDisplay.do?vid=MUL_ALMA&displayMode=full&docId=" + _doc[0] + "'>http://search.lib.monash.edu/primo_library/libweb/action/dlDisplay.do?vid=MUL_ALMA&displayMode=full&docId=" + _doc[0] + "</a>"); 
			           	   } else {
	   				   	   if (r7){
				       		//Catmum record - CARM1
	       		       		out.println("Copy this URL: (CARM1 Offsite Store copy)");
	       		       		out.println("<br/><br/>");
  	       		       		out.println("<a href='http://search.lib.monash.edu/primo_library/libweb/action/dlDisplay.do?vid=MUL_ALMA&displayMode=full&docId=" + _doc[0] + "'>http://search.lib.monash.edu/primo_library/libweb/action/dlDisplay.do?vid=MUL_ALMA&displayMode=full&docId=" + _doc[0] + "</a>"); 
			           		   } else {
							if (r8){			
								//Primo Central Record
								out.println("Copy this URL: (Primo Central Record)");
	       					        out.println("<br/><br/>");
								out.println("<a href='http://search.lib.monash.edu/primo_library/libweb/action/dlDisplay.do?loc=adaptor,primo_central_multiple_fe&vid=MUL_ALMA&docId=" + pcID + "'>http://search.lib.monash.edu/primo_library/libweb/action/dlDisplay.do?loc=adaptor,primo_central_multiple_fe&vid=MUL_ALMA&docId=" + pcID +"</a>");
							}
							else {
								out.println("URL cannot be created for this record.");
							}
						   }
					  }
				   }
			    }

			} 
		}
	}



        
		/** String[] _subj=(String[])searchResultFullDoc[record.length-1].getValuesNoHL().get(PnxConstants.SUBJECT);
				if (_subj != null) {
					String[] _subjects = _subj[0].split("; ");
					for (i=0; i< _subjects.length; i++) {
              				out.println("KW  - " + _subjects[i]);		}
				} */

                  out.println("</body>");
                  out.println("</html>");
                          		
            out.close();
            return null;

        }


        public String getContent(HttpServletRequest request,boolean fromBasket) {
                        return null;
        }

        public String getFormAction() {
                        return null;
        }




}
