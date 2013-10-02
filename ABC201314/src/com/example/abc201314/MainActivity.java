package com.example.abc201314;

import org.w3c.dom.Document;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;



public class MainActivity extends Activity {
	//このインタフェースは、名前からオブジェクトへのバインディングのセットから構成されるネーミングコンテキストを表します。
	//このインタフェースには、これらのバインディングを検査および更新するメソッドが含まれています。
	private Context mContext;
	
	// private final static int WC=LinearLayout.LayoutParams.WRAP_CONTENT;
	// private EditText editText;
	// アクティビティ起動時に呼ばれる
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		System.out.println("shori_start");
		mContext = this;
		
		class Bazaar {
			int bazaar_id;
			String group;
			String title;
			String content;

			// など

		}
		
		
		// 1.Runnable インタフェースを実装する
		// 2.run() メソッドを実装する
		// 3.実装クラスをインスタンス化する
		// 4.Thread クラスをインスタンス化する
		// 5.start() メソッドを呼び出す

		/*
		// バックグラウンド処理関連？
		Runnable runnable = new Runnable() {
			@Override
			// runメソッド オブジェクトが実装するインタフェース Runnable を使ってスレッドを作成し、
			// そのスレッドを開始すると、独立して実行されるスレッド内で、オブジェクトの run メソッドが呼び出されます。
			// スレッドとは1つのプログラム上で動作するある特定の処理のことを言います。
			// 1つのプログラム上でいくつもの処理を同時に実行しているかのように見せたい時に使用します。
			// このようなプログラムのことをマルチスレッドプログラムと言います。
			
			public void run() {
				// リストビューの作成
				// ListView listView = null;

				// 初期値
				MainActivity act = (MainActivity) mContext;
				// ListView_Banner? リストビューのID
				// データを保存して、画面遷移したあとにデータ表示
				// 画面遷移したあとでデータ表示でもOK
				// 処理中の画面を表示してもOK Net.java円が表示されるような画面
				//final String[] data = { "Apple", "Lemon", "Orange",
				//		"Strawberry" };
				
				
				// Document 型  
				//Document インタフェースは、HTML 文書または XML 文書全体を表します。概念上は文書ツリーのルートであり、文書データに最初にアクセスする手段を提供します。 
				Document xmlRoot = null;
				try {
					// XMLデータ取得
					System.out.println("run1");
					xmlRoot = Net.getBannerXml(act);
					if (xmlRoot == null) {
						System.out.println("run2");
					}
				} catch (SocketTimeoutException e) {
						System.out.println("run3");
				}
				
				//HTTP接続、パース処理？
				
				// 2013.9.10 Arrayは不要？
				// ArrayAdapterクラスはデータの一覧をリストなどのビューに渡すために使用されるクラスです。
				// ArrayAdapterクラスの定義
				// ArrayAdapter(Context context, int textViewResourceId, List<T>
				// objects)
				// コンテキストとTextViewのリソースID、各行のデータを示す配列オブジェクトを指定します。
				// void setListAdapter=(new ArrayAdapter<String>(this,
				// android.R.layout.bazaar_listview, data))
				//ArrayAdapter<String> adapter = new ArrayAdapter<String>(
				//		mContext, R.layout.bazaar_listview, 0, data);
				//ArrayAdapterクラスの管理するオブジェクトの型をString型に限定する
				ArrayAdapter<String> adapter = new ArrayAdapter<String>(
						mContext, R.layout.activity_sub);
				// アイテムを追加します
				// AdapterというのはViewとデータの橋渡し役で、
				// Viewに必要なデータを渡してあげる役割があります。
				// 要素の追加
				// arrayadapter.add("red");
				// arrayadapter.add("green");
				// arrayadapter.add("blue");
				// findViewById引数として指定されたidからビューを探す
				//ListView listView = (ListView) findViewById(R.id.ListView_Banner);
				ListView listView = (ListView) findViewById(R.id.textView1);
				System.out.println("run4");
				// listView = (ListView) act.findViewById(R.id.ListView_Banner);
				// ListViewクラスのオブジェクトを作成した時にリストに表示されるデータを登録する
				//データが無かったからエラーか？
				////////////////////////////////////listView.setAdapter((ListAdapter) xmlRoot);
				// リストビューのアイテムがクリックされた時に呼び出されるコールバックリスナーを登録します
				listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

					@Override
					public void onItemClick(AdapterView<?> parent, View view,
							int position, long id) {
						System.out.println("run5");
						ListView listView = (ListView) parent;
						// クリックされたアイテムを取得します
						String item = (String) listView
								.getItemAtPosition(position);
						Toast.makeText(MainActivity.this, item,
								Toast.LENGTH_LONG).show();
					}
				});
				// リストビューのアイテムが選択された時に呼び出されるコールバックリスナーを登録します
				listView.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
					@Override
					public void onItemSelected(AdapterView<?> parent,
							View view, int position, long id) {
						System.out.println("run6");
						ListView listView = (ListView) parent;
						// 選択されたアイテムを取得します
						String item = (String) listView.getSelectedItem();
						Toast.makeText(MainActivity.this, item,
								Toast.LENGTH_LONG).show();
					}

					@Override
					public void onNothingSelected(AdapterView<?> parent) {
						System.out.println("run7");
					}
				});
			}
		};
		System.out.println("run_start");
		runnable.run();
		System.out.println("run_end");
		*/
		
		//画面遷移処理
		//引数として指定されたidからビューを探す
	    Button btn = (Button)findViewById(R.id.button1);

	    //ボタンが押された時の処理
	    btn.setOnClickListener (new View.OnClickListener() {
	    //新画面？
	    //void setContentView(activity_sub1);
	    @Override
	    public void onClick(View button1) {
	    	System.out.println("button_start");
	    	// TODO Auto-generated method stub
	    	// インテントのインスタンス生成
	    	//今いるアクティビティから他のアクティビティを呼ぶ
	    	//•Intentの生成は第1引数に呼び出し元、第2引数に遷移先Activivtyを指定する
	    	Intent intent = new Intent(MainActivity.this, SubActivity.class);
	    	System.out.println("button1");
	    	//バックスレッドで実行する
	    	/*
	    	try
	        {
	    		System.out.println("test1");
	    		//URLからHttpGetクラスのインスタンスを作成します。
	    		String url = "http://www.android-group.jp/conference/abc2012s/api/bazaar/";
	            HttpGet method = new HttpGet( url );

	            System.out.println("test2");
		    	//DefaultHttpClientのインスタンスを作成します。
		    	//HTTPクライアントとは、「クライアント-サーバ間で、HTTP通信を行うためにTCP接続を確立する」ためのプログラム
	            DefaultHttpClient client = new DefaultHttpClient();

	            System.out.println("test3");
	            //HttpGetクラスのインスタンスのsetHeaderメソッドを呼び出し、ヘッダを設定します。
	            method.setHeader( "Connection", "Keep-Alive" );
	            
	            System.out.println("test4");
		    	//DefaultHttpClientクラスのexecuteメソッドを呼び出しHttpでアクセスします。引数にはHttpGetクラスのインスタンスを与えます。
		    	//Httpのレスポンスは戻り値のHttpResponseクラスに格納されます。
	            HttpResponse response = client.execute( method );
	            
	            System.out.println("test4.1");
	            int status = response.getStatusLine().getStatusCode();
	            System.out.println("test5");
	            
	            if ( status != HttpStatus.SC_OK )
		            System.out.println("test6");
	                throw new Exception( "" );
	        }
	        catch ( Exception e )
	        {
	            System.out.println("test9");
	            return;
	        }
	        */

	            
	            
	            

	    	
	    	/*  例その１
	    	System.out.println("test1");
	    	//URLからHttpGetクラスのインスタンスを作成します。
	    	String url = "http://www.android-group.jp/conference/abc2012s/api/bazaar/";
	    	HttpGet httpGet = new HttpGet(url);
	    	
	    	System.out.println("test2");
	    	//DefaultHttpClientのインスタンスを作成します。
	    	//HTTPクライアントとは、「クライアント-サーバ間で、HTTP通信を行うためにTCP接続を確立する」ためのプログラム
	    	DefaultHttpClient httpClient = new DefaultHttpClient();
	    	
	    	System.out.println("test3");
	    	//HttpGetクラスのインスタンスのsetHeaderメソッドを呼び出し、ヘッダを設定します。
	    	httpGet.setHeader("Connection","Keep-Alive");
	    	
	    	//DefaultHttpClientクラスのexecuteメソッドを呼び出しHttpでアクセスします。引数にはHttpGetクラスのインスタンスを与えます。
	    	//Httpのレスポンスは戻り値のHttpResponseクラスに格納されます。
	    	//とりあえずとばす
	    	System.out.println("test4");
	    	HttpResponse response = null;
	    	System.out.println("test5");
			try {
				System.out.println("test6");
				response = httpClient.execute(httpGet);
				System.out.println("test7");
			} catch (ClientProtocolException e) {
		    	System.out.println("test8");
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			} catch (IOException e) {
		    	System.out.println("test9");
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
	    	
	    	System.out.println("test10");
	    	//HttpResponseのステータスコードを取得します。
	    	int status = response.getStatusLine().getStatusCode();
	    	
	    	if (status != HttpStatus.SC_OK){
	    		try {
					throw new Exception("");
				} catch (Exception e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}
	    	} else {
	    		String receive = null;
				try {
					receive = EntityUtils.toString(response.getEntity(),"UTF-8");
				} catch (ParseException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				} catch (IOException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}
	    		TextView textview1 = (TextView)findViewById(R.id.textView1);
	    		textview1.setText(receive);
	    	}
	    	*/

	    	
	    	/* ダミーデータ版
	    	//intent.puExtra("キーとなる文字列","渡したい値");
	    	String  bazaar_group= "株式会社ビデオマーケット";
	    	String  bazaar_title= "Bazaar XML API | Android Bazaar and Conference 2012 Spring";
	    	String  bazaar_content= "2万5千本以上の作品を配信する国内最大モバイル動画配信サービス「ビデオマーケット」。こだわりの高品質動画をお届けする為、高品質な女性があなたの端末をお拭きします。更にその場で会員登録してくれた方には、スマートフォンスタンドをプレゼント";
	    	int  bazaar_location= 1;
	    	//少量のデータ
	    	//大量データの場合はDBのSQLiteを使う
	    	intent.putExtra("key_bazaar_group",bazaar_group);
	    	intent.putExtra("key_bazaar_title",bazaar_title);
	    	intent.putExtra("key_bazaar_content",bazaar_content);
	    	intent.putExtra("key_bazaar_location",bazaar_location);
	    	// 次画面のアクティビティ起動
	    	//intentの中にデータを入れる?
	    	startActivity(intent);
	    	*/
	    	
	    	//本当はDocument型だと思う dummyデータのため、String
	    	String dummydata2 = "<?xml version=\"1.0\" encoding=\"UTF-8\" ?><bazaarInfo updateDate=\"2012-03-22 23:00:37\"><bazaar><group><![CDATA[株式会社ビデオマーケット]]></group><title>Bazaar XML API | Android Bazaar and Conference 2012 Spring</title><content><![CDATA[2万5千本以上の作品を配信する国内最大モバイル動画配信サービス「ビデオマーケット」。こだわりの高品質動画をお届けする為、高品質な女性があなたの端末をお拭きします。更にその場で会員登録してくれた方には、スマートフォンスタンドをプレゼント！]]></content><location>1</location></bazaar><bazaar><group><![CDATA[FXI Technologies]]></group><title><![CDATA[Cotton Candyという世界最小USB型のAndroid端末のご紹介]]></title><content><![CDATA[この小ささで、ハードのスペックは、Galaxy S2と同じだというから驚きです。でも、逆に言うと、Android携帯から、一番かさばっているタッチスクリーンと電池を取り外したと思えばいいのかも。日本でも、既に1000台（個？）以上売れているそうです。ABC2012では、Cotton Candyの実物展示を行います。]]></content><location>2</location></bazaar><bazaar><group><![CDATA[ngi group株式会社]]></group><title><![CDATA[広告収益を最大化する『AdStir』]]></title><content><![CDATA[課金以外でも広告をうまく使うことで収益率を上げることが可能です。海外でも取り入れられている広告配信をまとめる仕組み『AdStir』を開発しました。ネットワーク広告とRTB広告を最適化する広告プラットフォームのご紹介します。]]></content><location>3</location></bazaar></bazaarInfo>";
    	

	    	System.out.println("button2");

	    	//intent.puExtra("キーとなる文字列","渡したい値");
	    	intent.putExtra("key_bazaar_dummy",dummydata2);

	    	
	    	// 次画面のアクティビティ起動
	    	//intentの中にデータを入れる?
	    	startActivity(intent);
	    	
	    	}


	    	
	    	
	    	
	    	

	    });
	    System.out.println("shori_end");
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
