# Symmetric Cryptography Algorithms

## What is cryptography ?
Cryptography is a method of protecting information and communications through the use of codes so that only those for whom the information is intended can read and process it. The pre-fix "crypt" means "hidden" or "vault" and the suffix "graphy" stands for "writing."

### Algorithms
<ol>
  <li><a href="https://github.com/HouariZegai/Symmetric-Cryptography/blob/master/src/com/houarizegai/crypto/CBC.java">CBC</a></li>
  <li><a href="https://github.com/HouariZegai/Symmetric-Cryptography/blob/master/src/com/houarizegai/crypto/CFB.java">CFB</a></li>
  <li><a href="https://github.com/HouariZegai/Symmetric-Cryptography/blob/master/src/com/houarizegai/crypto/ECB.java">ECB</a></li>
  <li><a href="https://github.com/HouariZegai/Symmetric-Cryptography/blob/master/src/com/houarizegai/crypto/OFB.java">OFB</a></li>
  <li><a href="https://github.com/HouariZegai/Symmetric-Cryptography/blob/master/src/com/houarizegai/crypto/Feistel.java">Feistel</a></li>
</ol>

### Problem solving
<ul>
  <li><a href="https://github.com/HouariZegai/Symmetric-Cryptography/tree/master/src/com/houarizegai/crypto/crypto_algo1" >Problem 1</a></li>
</ul>

### An example of using the CBC algorithm

    String plainText = "01001001";
    String key = "1010";
    int vi = 4;
    
    CBC cbc = new CBC();
    String cryptogram = cbc.encrypt(plainText, key, vi); // Encrypt plain msg
    System.out.println("Encrypt : " + cryptogram);
    
    String plainTextResult = cbc.decrypt(cryptogram, key, vi); // Decrypt msg
    System.out.println("Decrypt : " + plainTextResult);
 
## Installation
##### Clone this project by type in the bash the following command:
    git clone https://github.com/HouariZegai/Symmetric-Cryptography.git
