# Android Icon Generator
Android Icon Generator is a simple app that generates downscaled icons for all android supported densities (as stated 
by the [documentation](http://developer.android.com/guide/practices/screens_support.html#range)). 

## What you need
- JRE 8 or newer
- The icons icons in great resolution from witch others resolutions will be generated

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
The output will be generated into the selected folder. AIG generates icons in all supported screens resolutions (as stated
by the [documentation](http://developer.android.com/guide/practices/screens_support.html#range)). 

Example of an output folder generated from the upper example:

![Example of an output folder]
(http://i.imgur.com/L1wkaTo.png)