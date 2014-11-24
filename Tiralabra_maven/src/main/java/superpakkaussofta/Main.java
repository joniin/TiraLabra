/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package superpakkaussofta;

/**
 * Main class.
 *
 * @author Jouko
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //pääasiassa testijuttuja vielä tässä vaiheessa
        FileIO fio = new FileIO();
        HuffmanCompressor compressor = new HuffmanCompressor();
        
        uncompress(fio, compressor);
        //compress(fio, compressor);
        /*
        NodeHeap h = new NodeHeap();
        h.add(new HuffmanNode((byte) 3, 3));
        h.add(new HuffmanNode((byte) 4, 4));
        h.add(new HuffmanNode((byte) 2, 2));
        h.add(new HuffmanNode((byte) 5, 5));
        h.add(new HuffmanNode((byte) 27, 27));
        h.add(new HuffmanNode((byte) 5, 5));
        h.add(new HuffmanNode((byte) 20, 20));
        h.add(new HuffmanNode((byte) 1, 1));
        h.add(new HuffmanNode((byte) 8, 8));
        h.add(new HuffmanNode((byte) 11, 11));
        h.add(new HuffmanNode((byte) 22, 22));
        h.add(new HuffmanNode((byte) 13, 13));
        h.add(new HuffmanNode((byte) 15, 15));
        
        System.out.println("Nodeja pukkaa:");
        while(h.size() > 0)
            System.out.println(h.poll() + ", koko: " + h.size());
        */
        
    }
    private static void compress(FileIO fio, HuffmanCompressor compressor){
        String path = "testifilu2.txt";
        
        byte[] data = null;
        try {
            data = fio.read(path);
        } catch (Exception e) {
            System.out.println("luku feilas");
        }
        
        System.out.println("Alkuperäinen:");
        for(int i = 0; i < data.length; i++){
            System.out.println(data[i]);
        }
        
        byte[] compr = compressor.compress(data);
        
        
        try {
            fio.write(compr, path + ".huf");
        } catch (Exception e) {
            System.out.println("Tallentaminen feilas:");
            System.out.println(e);
        }
    }
    private static void uncompress(FileIO fio, HuffmanCompressor compressor){
        String path = "testifilu2.txt.huf";
        
        byte[] data = null;
        try {
            data = fio.read(path);
        } catch (Exception e) {
            System.out.println("luku feilas");
        }
        
        byte[] uncompr = compressor.decompress(data);
        
        try {
            fio.write(uncompr, path + ".ava");
        } catch (Exception e) {
            System.out.println("Tallentaminen feilas:");
            System.out.println(e);
        }
    }
    
}
