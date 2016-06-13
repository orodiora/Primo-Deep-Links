# Primo-Deep-Links

Author: R. Orodio

This Push to Adaptor code is written to provide shortcuts to Primo users for stable links.
Compatible with Primo 4.4

Copy the following jar files to your working directory within the Primo server if you are unable to locate them within Primo.

But otherwise the jar files should exists within: /exlibris/primo/p4_1/ng/primo/home/profile/search/pushTo/EndNoteLocalJAR/

To compile the java code, ensure the following paths are set:

    setenv CLASSPATH "${CLASSPATH}:/exlibris/primo/p4_1/ng/primo/home/profile/search/pushTo/EndNoteLocalJAR/primo_library-common.jar"
    setenv CLASSPATH "${CLASSPATH}:/exlibris/primo/p4_1/ng/primo/home/profile/search/pushTo/EndNoteLocalJAR/jaguar-client.jar"
    setenv CLASSPATH "${CLASSPATH}:/exlibris/primo/p4_1/ng/primo/home/profile/search/pushTo/EndNoteLocalJAR/primo_common-infrastructure.jar"
    setenv CLASSPATH "${CLASSPATH}:/exlibris/primo/p4_1/ng/primo/home/profile/search/pushTo/EndNoteLocalJAR/xbean.jar"
    setenv CLASSPATH "${CLASSPATH}:/exlibris/primo/p4_1/ng/primo/home/profile/search/pushTo/EndNoteLocalJAR/javax.servlet.jar"
    setenv CLASSPATH "${CLASSPATH}:/exlibris/primo/p4_1/ng/primo/home/system/thirdparty/openserver/server/search/deploy/primo_library-print app.ear/primo_library-libweb.war/WEB-INF/classes/"
    setenv CLASSPATH "${CLASSPATH}:/exlibris/primo/p4_1/ng/primo/home/system/thirdparty/jbossas/server/search/deploy/primo_library-app.ear/primo_library-libweb.war/WEB-INF/classes"

Copy the class to:
    /exlibris/primo/p4_1/ng/primo/home/system/thirdparty/openserver/server/search/deploy/primo_library-app.ear/primo_library-libweb.war/WEB-INF/classes/com/exlibris/ primo/utils

   /exlibris/primo/p4_1/ng/primo/home/system/thirdparty/jbossas/server/search/deploy/primo_library-app.ear/primo_library-libweb.war/WEB-INF/classes/com/exlibris/primo/utils   (Primo 4.4)

 Attached is the Java Code and Jar files that might be needed to compile the script. Make sure you use the attached JAR files. The current JAR versions seem to be missing certain libraries/functions.
 Restart the FE services to finally complete deployment.
 Once compiled, make sure to add the class under Adaptors : Pusto Adaptors Mapping table
 If needed to rename, go to Front End > Keeping this item Tile under code tables, then rename the appropriate field.
