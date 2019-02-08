/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package block;

/**
 *
 * @author Pablo
 */
public class prueba {
    	public static void main(String args[]) {
		
		Blockchain tcpCoin = new Blockchain();
		//se crea los bloques
		Block a = new Block("0x200", new java.util.Date(), "<transactiones>");
		Block b = new Block("0x200", new java.util.Date(), "<transactiones>");
		Block c = new Block("0x200", new java.util.Date(), "<transactiones>");
		
		tcpCoin.addBlock(a);
		tcpCoin.addBlock(b);
		tcpCoin.addBlock(c);
		
		tcpCoin.getLatestBlock().setPreviousHash("ABCDEFG");
		
		tcpCoin.displayChain();
		
		tcpCoin.isValid();

	}
}
