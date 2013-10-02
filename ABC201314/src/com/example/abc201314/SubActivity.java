package com.example.abc201314;

import java.net.SocketTimeoutException;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class SubActivity extends Activity {
	
	//ここに定義すればこのクラスの中でどこでも使えるはず
	//String bazaar_dummy = ""；
	String tamesi ="";
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sub);
		String bazaar_group = "";
		String bazaar_title = "";
		String bazaar_content = "";
		int bazaar_location = 0;

		//バンドル  前回起動した状態から始める
		Bundle extras=getIntent().getExtras();
			Runnable runnable1 = new Runnable() {
				@Override
				public void run() {
					//Document xmlとか タグのようなもの
					Document xmlRoot = null;
					try {
						//xmlを変換
						MainActivity act = null;												
						xmlRoot = Net.getBannerXml(act);
						if(xmlRoot == null){
							// スルーさせる
						}
						System.out.println("test_out_xmlRoot=" + xmlRoot);
					} catch (SocketTimeoutException e) {
						System.out.println("SubACtivity_reigai_1");

					}
					catch (Exception e) {
						e.printStackTrace();
						System.out.println("SubACtivity_reigai_2");

						try {
							throw new SocketTimeoutException();
						} catch (SocketTimeoutException e1) {
							System.out.println("SubACtivity_reigai_3");
							// TODO 自動生成された catch ブロック
							e1.printStackTrace();
						}
					}
					// 選択中のエリアに沿うIDを取得する
					String selectedMidAreaIndex = null;
					String selectedMidArea = null;
					//xmlが取得できているか判定
					if (xmlRoot != null){
						 //String content = xmlRoot;
						 	/*XML ドキュメントから DOM Document インスタンスを取得する API を定義します。このクラスを使用すると、アプリケーションプログラマは XML Document を取得できます。
							SAX の一般的なエラーまたは警告をカプセル化します。
							 SAX  XMLパーサの標準APIの1つである 
							SAX（Simple API for XML）もDOMと同様の働きをするXMLパーサ用のAPIです。
							　DOMを用いたプログラミングでは、まずXML文書を構文解析し、文書の構造に対応したオブジェクトのツリーを取得していました。
							　対してSAXのプログラミングでは、XML文書の構文解析を始める点は同じですが、構文解析を済ませてから処理をするのではなく、構文解析を進めながら必要な情報を取得していきます。
							 */
						NodeList nodeList = xmlRoot.getElementsByTagName("bazaarInfo");
						Node node0 = nodeList.item(0);
						System.out.println("node0=" + node0);
						System.out.println("node0_nodename=" + node0.getNodeName());
						NodeList nodeList1 = node0.getChildNodes();
						System.out.println("nodeList=" + nodeList);
						try {
							//////////////////////////////////////////////////////////////////////////
							//XMLデータを操作する～DOMの詳細
							//http://www.atmarkit.co.jp/fxml/rensai/rexml11/rexml11.html
							//////////////////////////////////////////////////////////////////////////
							//XPathでは、要素や属性の部分をノードと呼びます。
							//外側から順にもってくる １ノード、２ノード・・・・・・・・・・・
							//getLength バイト数？
							System.out.println("nodeList1_getLength=" + nodeList1.getLength());
							for (int i = 0; i < nodeList1.getLength(); i++) {
								//ノード
								//item 集合内の index 番目の項目を返します。
								Node node = nodeList1.item(i);
								System.out.println("node_nodename=" + node.getNodeName());
									//複数の子ノードをまとめて取り出す 
									//このノードの子をすべて含む NodeList です。子が存在しない場合、ノードを持たない NodeList が返されます。 
									NodeList banners = node.getChildNodes();
									System.out.println("banners_getLength=" + banners.getLength());
									
									//文字の可変シーケンスです
									StringBuilder bazaar_set = new StringBuilder();
									for (int i2 = 0; i2 < banners.getLength(); i2++) {
										try {
											Node bannerNode = banners.item(i2);
											System.out.println("bannerNode_nodename=" + bannerNode.getNodeName());
											if (bannerNode.getNodeType() == Node.ELEMENT_NODE) {
												//タグの名前を取得
												String elementName = bannerNode
														.getNodeName();
												
												String elementValue = null;
												
												if (elementName.trim().equals(
														"bazaar_id")) {
													NodeList banners2 = bannerNode.getChildNodes();
													Node node_bazaar_id = banners2.item(0);
													elementValue = node_bazaar_id.getNodeValue();
													System.out.println("test_out_bazaar_id =" + elementValue);
													bazaar_set.append(elementValue);
													bazaar_set.append("\n");
												} else if (elementName.trim().equals(
														"days")) {
													NodeList banners2 = bannerNode.getChildNodes();
													Node node_days = banners2.item(0);
													elementValue = node_days.getNodeValue();
													System.out.println("test_out_days =" + elementValue);
													bazaar_set.append(elementValue);
													bazaar_set.append("\n");
												} else if (elementName.trim().equals(
														"group")) {
													NodeList banners2 = bannerNode.getChildNodes();
													Node node_group = banners2.item(0);
													elementValue = node_group.getNodeValue();
													System.out.println("test_out_group =" + elementValue);
													
													bazaar_set.append(elementValue);
													bazaar_set.append("\n");
													String test1 = elementValue;
													System.out.println("test1=" + test1);
												} else if (elementName.trim().equals(
														"title")) {
													NodeList banners2 = bannerNode.getChildNodes();
													Node node_title = banners2.item(0);
													elementValue = node_title.getNodeValue();
													System.out.println("test_out_title =" + elementValue);
													bazaar_set.append(elementValue);
													bazaar_set.append("\n");
												} else if (elementName.trim().equals(
														"content")) {
													NodeList banners2 = bannerNode.getChildNodes();
													Node node_content = banners2.item(0);
													elementValue = node_content.getNodeValue();
													System.out.println("test_out_content =" + elementValue);
													bazaar_set.append(elementValue);
													bazaar_set.append("\n");
												} else if (elementName.trim().equals(
															"location")) {
													NodeList banners2 = bannerNode.getChildNodes();
													Node node_location = banners2.item(0);
													elementValue = node_location.getNodeValue();
													System.out.println("test_out_location =" + elementValue);
													bazaar_set.append(elementValue);
													bazaar_set.append("\n");
												}
											}
										} catch (Exception e) {
											System.out.println("SubACtivity_reigai_2");
										 		}
											}
									switch (i){
									case 0:
										TextView textview1 = (TextView)findViewById(R.id.textView1);
										textview1.setText(bazaar_set.toString());
										break;
									case 1:
										TextView textview2 = (TextView)findViewById(R.id.textView2);
										textview2.setText(bazaar_set.toString());
										break;
									case 2:
										TextView textview3 = (TextView)findViewById(R.id.textView3);
										textview3.setText(bazaar_set.toString());
										break;
									default:
										System.out.println("error!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
									}
										}			
							} catch (Exception e) {
								System.out.println("SubACtivity_reigai_3");
						}
						}
					}
			};

			runnable1.run();
			
			/*パース後の文字列を出力する
			TextView textview1 = (TextView)findViewById(R.id.textView1);
			textview1.setText(tamesi);
			*/
	}
}

