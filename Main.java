package application;


import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64.Decoder;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.scene.Scene;

public class Main extends Application {
	MainPage mainpage = new MainPage();
	StartPage startpage = new StartPage();
	TableScreen tablescr = new TableScreen();
	SizeScreen sizescr = new SizeScreen();
	//public static byte[] bufferInputs = new byte[16];
	public static byte[] bufferOutput = new byte[16];
	public byte read[];
	public static String head = "";
	public static StringBuilder bithead = new StringBuilder();
	public static char[] bitheads;
	public String headerend = "";
	public static String path;
	public static String r;
	public static int pointbit = 0;
	public static int bytenumber = 0;
	public static int counts = 0;
	public static int i = 0;
	public static int size = 0;
	public static int repbit = 1;

	public static Map<Character, String> huffmanCodesMap;
	public static Map<Character, String> decomphuffman;
	public static List<SortListhuff> result = new ArrayList<SortListhuff>();
	public static ObservableList<HuffTable> elements = FXCollections.observableArrayList();
	public static int bytescount = 0;
	public static int[] count = new int[256];
	public static int[] freqchar;
	public static char[] charar;
	public static byte[] charchar;
	public static Nodestack node = null;
	Stage stage1 = new Stage();
	Stage stage2 = new Stage();
	Stage stage3 = new Stage();
	Stage stage4 = new Stage();
	public static File filereadnow;
	public static File filede;
	public static long filebeforeInK=0;
	public static long fileafterInK=0;
	Scene scene1 = new Scene(mainpage.getGroup(), 1250, 600);
	Scene scene2 = new Scene(startpage.getBorder(), 1250, 600);
	Scene scene3 = new Scene(tablescr.getBordertable(), 1250, 600);
	Scene scene4 = new Scene(sizescr.getBp(),1250,600);

	@Override
	public void start(Stage primaryStage) {
		try {
			stage1.setScene(scene1);
			stage1.show();

			mainpage.getStart().setOnAction(e -> {
				stage2.setScene(scene2);
				stage2.show();
			});
			startpage.getMainp().setOnAction(e -> {
				stage1.setScene(scene1);
				stage2.close();
				stage1.show();
			});
			//////////////////////////////////////////////
			startpage.getSize().setOnAction(e->{
				sizescr.getLabelbefore().setText("The File Size In Kbytes is "+ filebeforeInK+ " KByte");
				sizescr.getLabelafter().setText(" The Size in Kbytes After Compress is : "+fileafterInK+ " KBytes .");
				stage4.setScene(scene4);
				stage4.show();
			});
			
			
			
			
			
			
			
/////////////////////////////// Read The File Chooser //////////////////////////////////////////////////	
			startpage.getFilechooser().setOnAction(e -> {
				FileChooser fe = new FileChooser();
				File file1 = fe.showOpenDialog(null);
				filereadnow = file1;
				filede = file1;

				try (BufferedReader reader = new BufferedReader(new FileReader(filede))) {
					int character;

					while ((character = reader.read()) != -1) {
						// Increment the frequency for each character
						count[character & 0xFF]++;

					  long fileSizeInBytes = file1.length();

			            // Convert bytes to kilobytes (optional)
			            long fileSizeInKB = fileSizeInBytes / 1024;
			            
			            filebeforeInK=fileSizeInKB;
					}
				}catch (IOException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
			});
//////////////////////////////// Compress //////////////////////////////////////////////
			startpage.getCompress().setOnAction(e -> {
				Huffman huffman = new Huffman();
                  huffmanCodesMap = new LinkedHashMap<>();
				stage1.close();
				int j = 0;
				for (int i = 0; i < count.length; i++) {
					if (count[i] != 0) {
						j++;
					}
				}
				freqchar = new int[j];
				charar = new char[j];
				j = 0;
				int pp = 0;
				for (int i = 0; i < count.length; i++) {
					if (count[i] != 0) {
						freqchar[j] = count[i];
						pp = i & 0xFF;
						charar[j] = (char) pp;
						System.out.println("Ehabozzzzzz   " +  pp);
						j++;
					}
				}
				PriorityQueue<Node> q = new PriorityQueue<>();
				huffman.BuildTreeofPriority(freqchar, charar, q, result, huffmanCodesMap);
				System.out.println(result.toString());
				for (int i = 0; i < freqchar.length; i++) {
					bytescount = bytescount + freqchar[i];
				}

				System.out.println(bytescount);
				Node root = q.peek();
				huffman.stringheader(root);
				// Main.head=Main.head+"0";
				bitheads = new char[head.length()];
				for (int i = 0; i < head.length(); i++) {
					bitheads[i] = head.charAt(i);
				}

				int a = 0;
				int p = 0;
				for (int i = 0; i < bitheads.length; i++) {
					if (a == 0) {
						bithead.append(bitheads[i]);
						System.out.println(bitheads[i]);
						a = 1;
					} else {
						if (p == 1) {
							if ((bitheads[i - 1] == '1' && bitheads[i - 2] == '1' && bitheads[i] == '1')
									|| (bitheads[i - 1] != '1' && bitheads[i] == '1')
									|| (bitheads[i - 1] != '1' && bitheads[i] == '0')
									|| (bitheads[i - 1] == '1' && bitheads[i - 2] == '1' && bitheads[i] == '0')) {
								bithead.append(bitheads[i]);
								System.out.println("ha" + bitheads[i]);
								System.out.println("one time only");
								p = 2;
							} else {
								String binaryRepresentation = String.format("%8s", Integer.toBinaryString(bitheads[i]));
								
								
								
								bithead.append(binaryRepresentation);
								p = 2;

							}

						}

						else if (p == 2) {
							if ((bitheads[i - 1] == '1' && bitheads[i - 2] == '1' && bitheads[i] == '1')|| (bitheads[i - 3] != '1' && bitheads[i - 1] == '1' && bitheads[i - 2] == '1'&& bitheads[i] == '0')
									|| (bitheads[i - 1] != '1' && bitheads[i] == '1')
									|| (bitheads[i - 1] != '1' && bitheads[i] == '0')) {
								bithead.append(bitheads[i]);
								System.out.println("ha" + bitheads[i]);
								p = 2;
							} else {
								String binaryRepresentation = String.format("%8s", Integer.toBinaryString(bitheads[i]));
								bithead.append(binaryRepresentation);
								p = 2;
							}

						} else {
							p = 1;
							String binaryRepresentation = String.format("%8s", Integer.toBinaryString(bitheads[i]));
							bithead.append(binaryRepresentation);
						}
					}

				}
				System.out.println("bbbbbbbbbb--> " + Main.head);
				System.out.print(bithead);
				System.out.print("------------------------------------------");
				for (int i = 0; i < bithead.length(); i++) {
					if (bithead.charAt(i) == ' ') {
						bithead.setCharAt(i, '0');
					}
				}

				System.out.println(bithead);
				headerend = binaryStringToAscii(bithead);
				System.out.println(headerend);
				int[] rr = new int[headerend.length()];
				for (int i = 0; i < rr.length; i++) {
					rr[i] = headerend.charAt(i);
				}
				//String outputFile = "ehaboz.huf";
				  String userHome = System.getProperty("user.home");

			        // Create the Downloads directory path
			        Path downloadsPath = FileSystems.getDefault().getPath(userHome, "Downloads");

			        // Create the output file path
			        Path outputPath = downloadsPath.resolve("ehaboz.huff");

				// a=0;
				try (
						FileOutputStream fileOutputStream = new FileOutputStream(outputPath.toFile(), true);) {

					fileOutputStream.write(filereadnow.getName().getBytes());
					fileOutputStream.write('\n');
					for (int k = 0; k < rr.length; k++) {
						fileOutputStream.write((char) (rr[k] & 0xFF));
					}
					fileOutputStream.write("End".getBytes());
					
					// int countl=0;
					String compressedOutput = "";
					
					// String inputString="";0
					int byteRead;
					
					//int [] charstri= new int[16];
					char[] bufferInputs= new char[16];
					try (FileInputStream fileInputStream = new FileInputStream(filereadnow);
						     InputStreamReader reader = new InputStreamReader(fileInputStream, StandardCharsets.UTF_8)) {
						    // Read characters using the reader
					 while ((byteRead =reader.read(bufferInputs)) != -1) {
						   StringBuilder stringBuilder = new StringBuilder();

					        for (int i = 0; i < byteRead; i++) {
					            int unicodeValue = bufferInputs[i]& 0xFF; 
			
					            stringBuilder.append( (char)unicodeValue);
					        }
					        String utf8String = stringBuilder.toString();
					        System.out.println("UTF-8 String: " + utf8String);
					        // Now utf8String contains the 16 bytes as a single String
					       
//		
//	                	 String utf8String = new String(bufferInputs, 0, byteRead, StandardCharsets.UTF_8);
//                          charstri= new int[utf8String.length()];
//	                  System.out.println("helllllllloooooooooooooo");
//                          
//	                     System.out.println("UTF-8 String: " + utf8String);
//	                     System.out.println("UTF-8 String len : " + utf8String.length());
//	                     
//                      
//	                     // Print the decimal values of each character in the UTF-8 string
//	                     int nn=0;
//	                     for (char c : utf8String.toCharArray()) {
//	                         int decimalValue = (int) c;
//	                         charstri[nn]=decimalValue;
//	                         System.out.println("egab value   "+charstri[nn]);
//	                        
//	                         nn++;
//	                     }
	                     
	                    // nn=0;
	                 
//	                     for(int i=0;i<charstri.length;i++) {
//	 	                    inputString=inputString+charstri[i];
//	                            }0
//	                     
//					while ((bytesRead = fileInputStream.read(bufferInputs)) != -1) {
//
//						String inputString = "";
//						for (int k = 0; k < bufferInputs.length; ++k) {
//							if (bufferInputs[k] < 0) {
//								bufferInputs[k] = (byte) (bufferInputs[k] & 0xFF);
//								inputString = inputString + new String(bufferInputs, 0, bytesRead);
//
//							} else {
//								inputString = new String(bufferInputs, 0, bytesRead);
//							}
//
//						}

					        String inputString=stringBuilder.toString();
						compressedOutput = Encoding.Compressdata(inputString, huffmanCodesMap);

						String s = compressedOutput;
						System.out.println("The Stringggggggggggg -->   " + s);
						i = 0;
						while (i <= s.length() - 1) {
							if (bytenumber > 15) {
								System.out.println("welcome to new game !!! ");
								for (int i = 0; i <= 15; i++) {
										if (bufferOutput[i] < 0) {
											int km = bufferOutput[i];
											km = km & 0xFF;
											bufferOutput[i] = (byte) km;
											fileOutputStream.write(bufferOutput[i]);
											System.out.println(bufferOutput[i] + " --> " + i);
										} else {
											fileOutputStream.write(bufferOutput[i]);
											System.out.println(bufferOutput[i] + " --> " + i);
										}
									
								}
								for (int d = 0; d <= bufferOutput.length - 1; d++) {
									bufferOutput[d] = 0;
								}

								if (i != s.length()) {
									int l = 0;
									System.out.println("the String of s : " + s);
									System.out.println("the i is  + " + i);
									for (int u = i; u <= s.length() - 1; u++) {
										if (l == 0) {
											r = String.valueOf(s.charAt(u));
											System.out.println("character is : " + s.charAt(u));
											l = 1;
										} else {
											r = r + String.valueOf(s.charAt(u));
										}

									}
									System.out.println("new r stirng ehab :" + r);
									System.out.println("length of r stirng ehab :" + r.length());
									s = "";
									bytenumber = 0;
									pointbit = 0;
									counts = 0;
									i = 0;
									int x = 0;
									while (x <= r.length()-1) {
										if (counts != 8) {
											System.out.println("iyaddddddddddddddddd  --> " + bytenumber + "---kkk "
													+ bufferOutput[bytenumber]);
											pointbit = 7 - counts % 8;
											int y = (Character.getNumericValue(r.charAt(x)));
											bufferOutput[bytenumber] = (byte) (bufferOutput[bytenumber]
													| y << pointbit);
											counts++;
											x++;
										} else {
											System.out.println("iyaddddddddddddddddd  --> " + bytenumber + "---kkk "
													+ bufferOutput[bytenumber]);
											bytenumber++;
											pointbit = 0;
											counts = 0;
										}
										if (bytenumber > 15) {
											System.out.println("welcome to new game 2222222222!!! ");
											System.out.println("The Game 222 r string is + " + x);
											for (int i = 0; i <= 15; i++) {

												if (bufferOutput[i] < 0) {
													int km = bufferOutput[i];
													km = km & 0xFF;
													bufferOutput[i] = (byte) km;
													fileOutputStream.write(bufferOutput[i]);
													System.out.println(bufferOutput[i] + " --> " + i);
												} else {
													fileOutputStream.write(bufferOutput[i]);
													System.out.println(bufferOutput[i] + " --> " + i);
												}
											}

											for (int d = 0; d <= bufferOutput.length - 1; d++) {
												bufferOutput[d] = 0;
											}
											bytenumber = 0;
											counts = 0;
											pointbit = 0;
										}

									}

									System.out.println("the count is + " + counts);
									System.out.println("the pointbit is + " + pointbit);
									System.out.println("the bytenumber is + " + bytenumber);
									r = "";
									x = 0;
									break;
								} else {
									bytenumber = 0;
									pointbit = 0;
									counts = 0;
									i = 0;
									break;
								}
							} else {
								if (counts != 8) {
									pointbit = 7 - counts % 8;
									int jj = Character.getNumericValue(s.charAt(i));
									System.out.println("ehab ana hoon rakam  !!" + jj);
									bufferOutput[bytenumber] = (byte) (bufferOutput[bytenumber] | jj << pointbit);
									System.out.println("ehab ana hoon !!" + bufferOutput[bytenumber]);
									System.out.println("byte num: " + bytenumber);
									counts++;
									i++;
								} else {
									bytenumber++;
									System.out.println("emti7annn " + bytenumber);
									pointbit = 0;
									counts = 0;
								}
							}
						}
						
						
					}
				
					}catch (IOException f) {
						    f.printStackTrace();
						}
					i = 0;
					int w = pointbit;
					int c = 0;
					while (counts != 8 && pointbit != 0) {
						pointbit = 7 - counts % 8;
						bufferOutput[bytenumber] = (byte) (bufferOutput[bytenumber] | 0 << pointbit);
						System.out.println("ehab ana hoon !!" + bufferOutput[bytenumber]);
						System.out.println("byte num: " + bytenumber);
						counts++;
						c = 1;
					}
					System.out.println("The Value of C : " + c);

					
					for (int i = 0; i <=bytenumber; i++) {
							if (bufferOutput[i] < 0) {
								int km = bufferOutput[i];
								km = km & 0xFF;
								bufferOutput[i] = (byte) km ;
								fileOutputStream.write(bufferOutput[i] & 0xFF);
								System.out.println(bufferOutput[i] + " --> " + i);
							} else {
								fileOutputStream.write(bufferOutput[i] & 0xFF);
								System.out.println(bufferOutput[i] + " --> " + i);
							}
						 

					}
File f= new File("\"C:\\Users\\Ehab\\Downloads\\ehaboz.huff\"");
long fileSizeInBytes = f.length();

// Convert bytes to kilobytes (optional)
long fileSizeInKB = fileSizeInBytes / 1024;
       fileafterInK=fileSizeInKB ;
 
					fileOutputStream.write(Integer.toString(w).getBytes());
					fileOutputStream.close();
					

				} catch (IOException e1) {
					System.out.print("error");
					e1.printStackTrace();
				}
					

				startpage.getCompress().setVisible(false);
			});
			
			////////////////////////////////////////////////
			sizescr.getMainPage().setOnAction(e->{
				sizescr.getLabelafter().setText(null);
				sizescr.getLabelbefore().setText(null);
				stage4.close();
				stage2.setScene(scene2);
				stage2.show();
			});
			
			////////////////////////////////////////////////
			startpage.getDecomp().setOnAction(e -> {
			//	StringBuilder content = new StringBuilder();
				
				 //byte[] DATA = null;

			        try {
			            Path filePath = filede.toPath();
			            byte[] DATA = Files.readAllBytes(filePath);

			            StringBuilder stringBuilder = new StringBuilder();
			            int k = 0;

			            for (int i = 0; i < DATA.length; i++) {
			                if (DATA[i] != '\n') {
			                 //   System.out.println((char) DATA[i]);
			                    stringBuilder.append((char) (DATA[i] & 0xFF));
			                    k++;
			                } else {
			                    break;  // Stop reading when newline is encountered
			                }
			            }

			            String full = stringBuilder.toString();
			          //  System.out.println("Read until newline: " + full);
			    k=k+1;
		      int endIndex = findEndIndex(DATA, k);
		      int  [] headerarray=null;
		      int [] dataarray=null;
//System.out.println("The end index is "+ endIndex);
		        if (endIndex != -1 && endIndex < DATA.length - 1) {
		            // Calculate the length of the range between "k" and "End" (excluding "End")
		            int range1Length = endIndex - k;// here is the header 
                      endIndex=endIndex+2;
		            // Calculate the length of the range after "End" (excluding "End")
		            int range2Length = DATA.length - 1 - endIndex; // here is the data 

		            // Create two new arrays to store the ranges as unsigned integers
		             headerarray = new int[range1Length];
		             dataarray = new int[range2Length];

		            // Copy and convert the bytes to unsigned integers
		            for (int i = 0; i < range1Length; i++) {
		                headerarray[i] = DATA[k + i] & 0xFF;
		            }

		            for (int i = 0; i < range2Length; i++) {
		               dataarray[i] = DATA[endIndex + 1 + i] & 0xFF;
		            }
		          
		           

		            // Print or process the two arrays as needed
		           // System.out.println("Array between k and End (excluding End): " + Arrays.toString(headerarray));
		          //  System.out.println("Array after End (excluding End) to the end of file: " + Arrays.toString(dataarray));
		        } else {
		         //   System.out.println("Word 'End' not found in the array or it is the last element.");
		        }
		        String binaryString="";  
		        String binaryheader = "";
		        for(int r=0; r<=headerarray.length-1;r++) {
		             binaryString = Integer.toBinaryString(headerarray[r] & 0xFF);

		            // Ensure the binary string is 8 bits long with leading zeros if needed
		            while (binaryString.length() < 8) {
		                binaryString = "0" + binaryString;
		            }
		            binaryheader=binaryheader+binaryString;
		           
		        }
		    //    System.out.println("The count of binary head is -------> "+ binaryheader.length());
		      //  System.out.println ("Thr b str + "+ binaryheader);
		        int headindex=0;
		        int u=0;
		        Stack stack = new Stack();
		        String h="";
		        String header=binaryheader;
		        
		        int y=0;
		        for (int i = 0 ; i < header.length() ; i++){
		        
		        			if(header.charAt(i)=='1') {
		        				 y=i+9;
		        		 
		        			if(y<header.length()) {
		        				String j =header.substring(i+1,y);
		        				int number = Integer.parseInt(j, 2);
		        				//byte value =(byte) number;
		        				char ch=(char)number;
		        				Nodestack temp = new Nodestack(ch);
		        				System.out.println("hello ana hoon and the j is  "+j);
		        				stack.push(temp);
		        				i=y-1;
		        			}
		        					
		        			}
		        			
		        			else if(header.charAt(i)=='0') {
		        				System.out.println("bye bye bye bye");
		        				 if(Stack.countstacknodes!=1) {
		        				Nodestack right = stack.pop();
		                        Nodestack left = stack.pop();
		                       
		                        	
		                       
		                        Nodestack nodenew = new Nodestack('\0');
		                        nodenew.setRight(right);
		                        nodenew.setLeft(left);
		                        stack.push(nodenew);
		        				 }
		        			}
		        			
		        }	
		        node=stack.pop();
		        printList(node);
 
		        decomphuffman = new LinkedHashMap<>();
				Huffman huff = new Huffman();
				String stri="";
				huff.printLeafPathsdecom(node, stri, decomphuffman);
		        
				for (Map.Entry<Character, String> entry : decomphuffman.entrySet()) {
                    System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
                }

				
		        String read="";
		        binaryheader="";
		        binaryString="";
		        String binarydata="";
		        
		        for(int r=0; r<dataarray.length-2;r++) {
		             binaryString = Integer.toBinaryString(dataarray[r]&0xFF);

		            // Ensure the binary string is 8 bits long with leading zeros if needed
		            while (binaryString.length() < 8) {
		                binaryString = "0" + binaryString;
		            }
		            binarydata=binarydata+binaryString;
		           
		        }
		    //    System.out.println("The string data  "+binarydata);
	            try (FileOutputStream fileout = new FileOutputStream("huffman.txt",true)) {
		        int n=0;
		        int t=0;
		       // for(int w=0;w<binarydata.length();w++) {
		        	while(t <= binarydata.length()-1) {
		        	if(n==0) {
		        		 read=read+binarydata.charAt(t);
		        		 System.out.println("The read one time  read  "+read);
		        		 n=1;
		        	}
		        	if(decomphuffman.containsValue(read)) {
		        		 for (Map.Entry<Character, String> entry : decomphuffman.entrySet()) {
        		            if (entry.getValue().equals(read)) {
        		            	System.out.println("The contains "+entry.getValue());
         		            	System.out.println("The value of the key = "+entry.getKey() );
         		               char ch=entry.getKey();
         		               fileout.write(ch);
         		               read="";
       		        		     t++;
         		            	 read=read+binarydata.charAt(t);
   		        		
         		           System.out.println("The contains after read t"+read);
         		           break;
         		            }
		        	}
		        }
		        	else {
		        		System.out.println("The  not contains -->"+read);
		        			t++;
      		            	 read=read+binarydata.charAt(t);
		        		
		        }
		        	}
		        	
		        //}
//		        System.out.println("The loop  length is "+ yuyu);
//		        System.out.println("The t length is "+ t);
		        int hehe=binarydata.length();
		       // System.out.println("The binarrr length is "+hehe );
		      //  System.out.println("The read string is  "+read);
		        String ends=read;
		      //  System.out.println("The ends String is "+ ends);
		        binarydata="";
		        read="";
		        String fd="";
		        int kkk=dataarray[dataarray.length-3];
		        fd=Integer.toBinaryString( kkk & 0xFF);
		        while ( fd.length() < 8) {
		        	 fd = "0" +  fd;
	            }
		        String fg="";
		        int uuuu=dataarray[dataarray.length-4];
		        fg=Integer.toBinaryString( uuuu & 0xFF);
		        while ( fg.length() < 8) {
		        	 fg = "0" +  fg;
	            }
		        
		       // System.out.println("The  one in string first is "+fg);
		       // System.out.println("The last one in string first is "+fd);
		        
		        int a=dataarray[dataarray.length-2];
		        binarydata=Integer.toBinaryString(a & 0xFF);
		        while ( binarydata.length() < 8) {
		        	 binarydata = "0" +  binarydata;
	            }
		     //   System.out.println("The int a is "+ a +" The String rep "+binarydata);
		        int b =dataarray[dataarray.length-1];
		        int num = asciiToInteger(b);
		       // num=9-num;
		        int go=0;
		        if(num!=0) {
		        if(ends=="") {
		        	while(go<num) {
		        		ends=ends+binarydata.charAt(go);
		        		go++;
		        	}
		        	
		        	String d="";
		        	int ind=0;
		        	int index=0;
		        	while(index<=ends.length()-1) {
					if(ind==0) {
						d=d+ends.charAt(index);
						ind=1;
					}
					if(decomphuffman.containsValue(d)) {
		        		 for (Map.Entry<Character, String> entry : decomphuffman.entrySet()) {
       		            if (entry.getValue().equals(d)) {
        		            	System.out.println("The value of the key = "+entry.getKey() );
        		               char ch=entry.getKey();
        		               fileout.write(ch);
        		              d=""; 
        		             // ind=0;
        		              index++;
        		          	d=d+ends.charAt(index);
        		           break;
        		            }
		        	}
		        }
		        	else {
		        		index++;
		        		d= d+ends.charAt(index);
		        }
					
					}	
		        }
		        else{
		        	while(go<num) {
		        		ends=ends+binarydata.charAt(go);
		        		go++;
		        	}
		        	 System.out.println("end now is ----> ----->  "+ ends);
		        	String d="";
		        	int ind=0;
		        	int index=0;
		        	while(index <= ends.length()-1) {
						if(ind==0) {
							 d=d+ends.charAt(index);
							ind=1;
						}
						if(decomphuffman.containsValue(d)) {
			        		 for (Map.Entry<Character, String> entry : decomphuffman.entrySet()) {
	       		            if (entry.getValue().equals(d)) {
	        		            	System.out.println("The value of the key = "+entry.getKey() );
	        		               char ch=entry.getKey();
	        		               fileout.write(ch);
	        		              d=""; 
	        		              index++;
	        		              d=d+ends.charAt(index);
	        		           break;
	        		            }
			        	}
			        }
			        	else {
			        		index++;
			        		d= d+ends.charAt(index);
			        }
						
						}
		        	
		        }
		        }
		        else {
		        	
		        	ends=ends+binarydata;
		        	 System.out.println("end now is ----> ----->  "+ ends);
		        	String d="";
		        	int ind=0;
		        	int index=0;
		        	while(index <=ends.length()-2) {
						if(ind==0) {
							d=d+ends.charAt(index);
							ind=1;
						}
						if(decomphuffman.containsValue(d)) {
			        		 for (Map.Entry<Character, String> entry : decomphuffman.entrySet()) {
	       		            if (entry.getValue().equals(d)) {
	        		            	System.out.println("The value of the key = "+entry.getKey() );
	        		            	System.out.println("The d in 1 "+d);
	        		               char ch=entry.getKey();
	        		               fileout.write(ch);
	        		              d=""; 
	        		              index++;
	        		              d=d+ends.charAt(index);
	        		              System.out.println("The d in2"+d);
	        		           break;
	        		            }
			        	}
			        }
			        	else {
			        		System.out.println("The d  in 3"+d);
			        		index++;
			        		d= d+ends.charAt(index);
			        		System.out.println("The d in4"+d);
			        }
						
						}
		        	
		        	// fileout.write(ends.charAt(index));
		        }
		       
		        fileout.close();
		
			
		        }

				} catch (Exception eoo) {
					System.err.println("  ");
				}
			});

			startpage.getTable().setOnAction(e -> {
				for (int i = 0; i < result.size(); i++) {
					String binaryRepresentation = String
							.format("%8s", Integer.toBinaryString(result.get(i).getCharacter())).replace(" ", "0");
					elements.add(new HuffTable(String.valueOf(result.get(i).getCharacter()), binaryRepresentation,
							result.get(i).getS(), result.get(i).getS().length(), result.get(i).getFreq()));
				}

				tablescr.getHuftable().setItems(elements);
				stage2.close();
				stage1.close();
				stage3.setScene(scene3);
				stage3.show();
			});
			tablescr.getMainPage().setOnAction(e -> {
				elements.clear();
				tablescr.getHuftable().getItems().clear();
				stage3.close();
				stage2.setScene(scene2);
				stage2.show();
			});

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	 private static int findEndIndex(byte[] array, int startIndex) {
	        // Implement your logic to find the index of "End" in the array
	        // For simplicity, let's assume "End" is represented by {69, 78, 68} in ASCII
	        byte[] endMarker = {69, 110, 100};

	        for (int i = startIndex; i < array.length - endMarker.length + 1; i++) {
	            boolean found = true;
	            for (int j = 0; j < endMarker.length; j++) {
	                if (array[i + j] != endMarker[j]) {
	                    found = false;
	                    break;
	                }
	            }
	            if (found) {
	                return i;  // Return the index of "End"
	            }
	        }

	        return -1;  // "End" not found
	    }
	
	 private static String charToBinary(char c) {
	        // Convert the character to its ASCII value
	        int asciiValue = (int) c;

	        // Convert the ASCII value to binary representation
	        String binaryRepresentation = Integer.toBinaryString(asciiValue);

	        // Optionally, you can pad the binary representation with leading zeros
	        // to ensure it has a fixed length (e.g., 8 bits)
	        int paddingLength = 8 - binaryRepresentation.length();
	        if (paddingLength > 0) {
	            StringBuilder paddedBinary = new StringBuilder();
	            for (int i = 0; i < paddingLength; i++) {
	                paddedBinary.append('0');
	            }
	            paddedBinary.append(binaryRepresentation);
	            return paddedBinary.toString();
	        } else {
	            return binaryRepresentation;
	        }
	    }
	private static int findSequenceIndex(byte[] array, byte[] sequence) {
	    for (int i = 0; i <= array.length - sequence.length; i++) {
	        boolean found = true;
	        for (int j = 0; j < sequence.length; j++) {
	            if (array[i + j] != sequence[j]) {
	                found = false;
	                break;
	            }
	        }
	        if (found) {
	            return i; // Return the starting index of the sequence
	        }
	    }
	    return -1; // Sequence not found
	}
	public void printList(Nodestack node) {
		if (node != null) {
			printList(node.getLeft());
			printList(node.getRight());
			System.out.println(node.getCharacter());

		}

	}
	 public static int asciiToInteger(int asciiValue) {
	        // Assuming the input is a valid ASCII digit ('0' to '9')
	        int asciiValueOf0 = 48;
	        int numericValue = asciiValue - asciiValueOf0;
	        return numericValue;
	    }

	private static String binaryStringToAscii(StringBuilder binaryString) {
		StringBuilder asciiStringBuilder = new StringBuilder();

		// Remove spaces from the binary string
		// binaryString = binaryString.replaceAll(" ", "");

		// Pad the binary string with zeros if its length is not a multiple of 8
		while (binaryString.length() % 8 != 0) {
			binaryString.append('0');
		}

		// Process the binary string in chunks of 8 bits
		for (int i = 0; i < binaryString.length(); i += 8) {
			String first8bits = binaryString.substring(i, Math.min(i + 8, binaryString.length()));

			// Convert the 8-bit binary chunk to decimal
			int decimalValue = Integer.parseInt(first8bits, 2);

			// Convert the decimal value to a character
			char asciiChar = (char) decimalValue;

			// Append the character to the result string
			asciiStringBuilder.append(asciiChar);
		}

		return asciiStringBuilder.toString();
	}
}
