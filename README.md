# Android Icon Generator
Android Icon Generator is a simple app that generates downscaled icons for all android supported densities (the list of supported densities can be found 
[here](http://developer.android.com/guide/practices/screens_support.html#range)). 

## Download
You can [download the compiled jar file](http://kaladivo.github.io/android-icon-generator/AIG.jar). Or clone this repository
and compile it by your self.

## What you need
- JRE 8 or newer
- The icons in great resolution from witch others resolutions will be generated

## How to launch
In most cases you will be able to launch the the app by just double clicking on AIG.jar file. If it does not work you can also 
run it from the command line by typing `java -jar AIG.jar` (make sure you are in the same directory as the AIG.jar file).

## How to use
To generate icons you need to set input and output folders. 

![Image of AIG screen]
(http://i.imgur.com/De6jlxw.png)


### Inputs
The input icons must be structured into folders named [resource-type]-res (for example drawable-res) where resource
type is name of the folder that output images will be generated to (for example drawable-res will produce drawable-xdpi,
drawable-hdpi, drawable-mdpi, ...). All other folders (without -res suffix) will be ignored.

Name of the input files should be in this format [iconName]-[widthInDp].[suffix] (for example icon-50.png - for png image
that is 50dp wide.). All other files will be ignored.

Example of an Input folder:

![Example of an input folder structure]
(http://i.imgur.com/LequYt6.png)

### Outputs
The output will be generated into the selected folder. AIG generates icons in all supported screen resolutions (as stated
by the [documentation](http://developer.android.com/guide/practices/screens_support.html#range)) and automatically puts them
to the right folders (or creates them if they does not exist). 

Usually you will select res folder in your Android project as the output folder.

Example of an output folder generated from the upper example:

![Example of an output folder]
(http://i.imgur.com/L1wkaTo.png)



That's it. Enjoy!
