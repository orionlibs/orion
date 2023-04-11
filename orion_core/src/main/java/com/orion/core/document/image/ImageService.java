package com.orion.core.document.image;

import com.orion.core.abstraction.OrionService;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public class ImageService extends OrionService
{
    public static int getHeightBasedOnWidthToKeepAspectRatio(int actualWidth, int actualHeight, int targetWidth)
    {

        if(actualWidth > targetWidth)
        {
            double percentageOfWidthToKeep = 1.0 * targetWidth / actualWidth;
            return (int)(actualHeight * percentageOfWidthToKeep);
        }
        else
        {
            return actualHeight;
        }

    }


    public static BufferedImage resizeImage(String inputImagePath, int targetWidth, int targetHeight) throws Exception
    {
        File inputFile = new File(inputImagePath);
        BufferedImage inputImage = ImageIO.read(inputFile);
        return resizeImage(inputImage, targetWidth, targetHeight);
    }


    public static BufferedImage resizeImage(BufferedImage inputImage, int targetWidth, int targetHeight) throws Exception
    {
        Image resultingImage = inputImage.getScaledInstance(targetWidth, targetHeight, Image.SCALE_DEFAULT);
        BufferedImage outputImage = new BufferedImage(targetWidth, targetHeight, BufferedImage.TYPE_INT_RGB);
        outputImage.getGraphics().drawImage(resultingImage, 0, 0, null);
        return outputImage;
    }


    public static BufferedImage shrinkOrEnlargeImage(String inputImagePath, int targetWidth) throws Exception
    {
        File inputFile = new File(inputImagePath);
        BufferedImage inputImage = ImageIO.read(inputFile);
        return shrinkOrEnlargeImage(inputImage, targetWidth);
    }


    public static BufferedImage shrinkOrEnlargeImage(BufferedImage inputImage, int targetWidth) throws Exception
    {

        if(inputImage.getWidth() != targetWidth)
        {
            int targetHeight = getHeightBasedOnWidthToKeepAspectRatio(inputImage.getWidth(), inputImage.getHeight(), targetWidth);
            return resizeImage(inputImage, targetWidth, targetHeight);
        }
        else
        {
            return inputImage;
        }

    }
}