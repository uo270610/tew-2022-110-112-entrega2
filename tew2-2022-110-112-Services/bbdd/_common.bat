
@echo off

REM Vamos a definir la unidad S: asociada a la carpeta raiz de nuestro entorno-tew
REM Es importante respetar la unidad "S", ya que será la que se use SIEMPRE internamente en todas las configuraciones de nuestras herramientas.
set UNIDAD=S:
subst %UNIDAD% "%CD%"

REM Definimos variables de entorno necesarias para lanzar Eclipse
set APACHE_HOME=%UNIDAD%\apache
set JBOSS_HOME=%UNIDAD%\wildfly
set JAVA_HOME=%UNIDAD%\jdk
set PATH=%JAVA_HOME%\bin;%PATH%
set CLASSPATH=%JAVA_HOME%\lib\tools.jar;.;%CLASSPATH%
set WORKSPACE=%UNIDAD%\work
