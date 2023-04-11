package com.orion.core.document.pdf;

import com.orion.core.abstraction.OrionService;

public class PDFService extends OrionService
{
    /*
     * public static void main(String[] args) { File file = new
     * File("D:/downloads/1.pdf"); try { PDDocument document =
     * PDDocument.load(file); PDFTextStripper pdfStripper = new PDFTextStripper();
     * pdfStripper.setParagraphStart("/t"); pdfStripper.setSortByPosition(true);
     * //CSVService csv = new CSVService("D:/downloads/1.csv"); //csv.writeToCSV(new
     * String[] {"content"}); String content = ""; for(String line :
     * pdfStripper.getText(document).split(pdfStripper.getParagraphStart())) {
     * //content += line; //System.out.println(line); //csv.writeToCSV(new String[]
     * {line}); //if the line does not have a full stop then line.split("\\.")
     * returns //an array of length line.length() with line.length() empty strings
     * String[] sentences = line.split("\\."); for(String sentence : sentences) {
     * content += sentence.trim(); } }
     * FileService.saveStringToFile("D:/downloads/1.txt", content);
     * //csv.closeCSVFile(); document.close(); } catch(IOException e) {
     * e.printStackTrace(); } }
     */
}