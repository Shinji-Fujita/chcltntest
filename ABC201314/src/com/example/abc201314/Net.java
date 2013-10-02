package com.example.abc201314;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
//DefaultHttpClientでGETによる通信を行う


public class Net {
	//XMLデータ取得 変換
	//public static Document getBannerXml(MainActivity act) throws SocketTimeoutException{
	public static Document getBannerXml(MainActivity act) throws SocketTimeoutException{
		System.out.println("Net_start");
		//http://www.android-group.jp/conference/abc2012s/api/bazaar/
		//パース処理？ 変換処理       下へ
		//String wrk = doGetRequestCore("http://www.android-group.jp/conference/abc2012s/api/bazaar/");
		//String wrk = "<?xml version=\"1.0\" encoding=\"UTF-8\" ?><bazaarInfo updateDate=\"2012-03-22 23:00:37\"><bazaar><group><![CDATA[株式会社ビデオマーケット]]></group><title>Bazaar XML API | Android Bazaar and Conference 2012 Spring</title><content><![CDATA[2万5千本以上の作品を配信する国内最大モバイル動画配信サービス「ビデオマーケット」。こだわりの高品質動画をお届けする為、高品質な女性があなたの端末をお拭きします。更にその場で会員登録してくれた方には、スマートフォンスタンドをプレゼント！]]></content><location>1</location></bazaar><bazaar><group><![CDATA[FXI Technologies]]></group><title><![CDATA[Cotton Candyという世界最小USB型のAndroid端末のご紹介]]></title><content><![CDATA[この小ささで、ハードのスペックは、Galaxy S2と同じだというから驚きです。でも、逆に言うと、Android携帯から、一番かさばっているタッチスクリーンと電池を取り外したと思えばいいのかも。日本でも、既に1000台（個？）以上売れているそうです。ABC2012では、Cotton Candyの実物展示を行います。]]></content><location>2</location></bazaar><bazaar><group><![CDATA[ngi group株式会社]]></group><title><![CDATA[広告収益を最大化する『AdStir』]]></title><content><![CDATA[課金以外でも広告をうまく使うことで収益率を上げることが可能です。海外でも取り入れられている広告配信をまとめる仕組み『AdStir』を開発しました。ネットワーク広告とRTB広告を最適化する広告プラットフォームのご紹介します。]]></content><location>3</location></bazaar></bazaarInfo>";
		//2013.9.18
		String wrk = "<bazaarInfo updateDate=\"2013-03-30 21:55:43\"><bazaar><bazaar_id>16</bazaar_id><days>15,16</days><group>カイト株式会社</group><title>Bazaar XML API | ABC 2013 Spring</title><content>リリース10ヶ月で1,000を超えるメディアと提携したサービスappCのご案内。サービスの概要から実際の事例までを展示でご紹介します。</content><location>16</location></bazaar><bazaar><bazaar_id>17</bazaar_id><days>15,16</days><group>株式会社セラク</group><title>Androidで動く植物工場、スマート洗面台、新作ゲームアプリ「元祖天ぷら侍」、 当社のAndroidアプリエンジニア採用についてのご紹介</title><content>・Androidで動く植物工場（予定）現在、開発中のAndroidを使った未来型家庭菜園キットを初公開いたします。・スマート洗面台これまでに様々なメディアで取り上げられた「スマート洗面台」を展示いたします。Android＋Arduinoを組込んだ鏡型情報端末です。・元祖天ぷら侍累計85万ダウンロードを達成した天ぷら侍シリーズの2作目、「元祖天ぷら侍」を展示いたします。レアキャラが獲得できるクーポンを配布いたします。・Androidアプリエンジニア採用について現在当社で行っているAndroidアプリエンジニアの募集についてご説明いたします。会社説明会の予約も受け付けます。</content><location>17</location></bazaar><bazaar><bazaar_id>18</bazaar_id><days>15,16</days><group>マインドフリー株式会社</group><title>リアル対戦型手づくりお弁当！【Arduino製】 Cloud×Android×Arduino</title><content>リアル対戦ができるお弁当です！ArduinoとAndroidを連動させ、クラウドとAndroidをWebsocketによるリアルタイム通信を行い、対戦できるお弁当を展示予定です！お弁当箱に圧力センサーを設置し、食べた量を計ることにより専用アプリ内で攻撃等のイベントが発生します。是非これまでにない、次世代バトル型お弁当を体感しに来てください♪＜with ECCコンピュータ専門学校　スマートフォンアプリ研究サークル＞</content><location>18</location></bazaar></bazaarInfo>";
		//String wrk = "http://" + ctx.getResources().getString(R.string.app_api_domain) 
		//+ "?" + sRequest 
		//+ "&v=" + ctx.getResources().getString(R.string.app_api_version);
		System.out.println("Net1");
		//System.out.println(wrk);
		//DocumentBuilderFactory  アプリケーションで XML ドキュメントから DOM オブジェクトツリーを生成するパーサーを取得できるファクトリ API を定義します。 
		DocumentBuilderFactory dbfactory = DocumentBuilderFactory.newInstance();
		//DocumentBuilder   XML ドキュメントから DOM Document インスタンスを取得する API を定義します。このクラスを使用すると、アプリケーションプログラマは XML Document を取得できます。
		DocumentBuilder docbuilder = null;
		//本当はDocument型だと思う dummyデータのため、String
		Document doc=null;
		//String doc = null;
		try {
			//オブジェクトツリーを生成する？
			//現在設定されているパラメータを使用して DocumentBuilder の新しいインスタンスを作成します。 
			docbuilder = dbfactory.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			//パースエラー？
			e.printStackTrace();
		}
		System.out.println("Net2");
		
		
		
		
		
		try {
			//ByteArrayInputStream   ストリームから読み込まれたバイトを格納する内部バッファーを保持しています。内部カウンタによって、read メソッドで次に読み込まれるバイトを追跡します。
			//String wrk = null; ////////////////////////////////////////////仮
			
			
			//Document型のxmlを取得した場合に使うことにする tryすべて
			System.out.println("test_out_wrk=" + wrk);
			doc = docbuilder.parse(new ByteArrayInputStream(wrk.getBytes("UTF-8")));
			System.out.println("test_out_doc=" + doc);
			
			
			
			//docがnullになってる
		} catch (UnsupportedEncodingException e) {
			System.out.println("Net3");
			//文字のエンコーディングがサポートされていません
			//e.printStackTrace();
		} catch (SAXException e) {
			System.out.println("Net4");
			//SAXとは木構造で変換するDOMと違って先頭から一行ずつ読み込む
			//SAX の一般的なエラーまたは警告をカプセル化します。
			//SAX（Simple API for XML）もDOMと同様の働きをするXMLパーサ用のAPIです。
			//e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Net5");
			//なんらかの入出力例外の発生を通知するシグナルを発生させます。このクラスは、入出力処理の失敗、または割り込みの発生によって生成される例外の汎用クラスです。 
			//e.printStackTrace();
		}catch(Exception e){
			System.out.println("Net6");
			//Exception クラスとそのサブクラスは、通常のアプリケーションでキャッチされる可能性のある状態を示す Throwable の形式の 1 つです。 
			//e.printStackTrace();
		} //<- �G���R�[�h��XML���g�̃G���R�[�h�ɂ��킹��
		System.out.println("Net_END");
		
		return doc;
	}


	//HTTP接続、パース処理？ 変換処理
	private static String doGetRequestCore(String sUrl) throws SocketTimeoutException {
		System.out.println("Net_2_start");
		String sReturn = null;
		//DefaultHttpClientでGETによる通信を行う
		HttpGet httpGetObj = new HttpGet(sUrl);
		//URI で識別されるリソースに HTTP 要求を送信し、そのリソースから HTTP 応答を受信するための基本クラスが用意されています。 
		HttpClient httpClientObj = new DefaultHttpClient();
		HttpParams httpParamsObj = httpClientObj.getParams();
		HttpEntity httpEntityObj = null;
		InputStream inpurStreamObj = null;
		InputStreamReader inputStreamReaderObj = null;
		BufferedReader bufferedReaderObj = null;
		System.out.println("Net_2_1");
		// �ڑ��̃^�C���A�E�g�i�P�ʁFms�j
		//HttpConnectionParams.setConnectionTimeout(httpParamsObj, 30000);
		HttpConnectionParams.setConnectionTimeout(httpParamsObj, 30000);
		// �f�[�^�擾�̃^�C���A�E�g�i�P�ʁFms�j�T�[�o���̃v���O����(php�Ƃ�)��sleep�Ȃǂ��g���΃e�X�g�ł���
		//HttpConnectionParams.setSoTimeout(httpParamsObj, 10);
		//接続のタイムアウトを設定する （ミリ秒）
		HttpConnectionParams.setSoTimeout(httpParamsObj, 30000);
		
		httpParamsObj.setParameter("http.useragent", httpParamsObj.getParameter("http.useragent") + ",AndroidBaitoru");
		System.out.println("Net_2_2");
		try {
			// http���N�G�X�g�i���Ԑ؂�ȂǃT�[�o�ւ̃��N�G�X�g���ɖ�肪����Ɨ�O����������j
			HttpResponse httpResponseObj = httpClientObj.execute(httpGetObj);
			// http���X�|���X��400�ԑ�ȍ~�̓G���[������
			if (httpResponseObj.getStatusLine().getStatusCode() < 400) {
				System.out.println("Net_2_3");
				//
				httpEntityObj = httpResponseObj.getEntity();
				// ���X�|���X�{�̂��擾
				inpurStreamObj = httpEntityObj.getContent();

				inputStreamReaderObj = new InputStreamReader(inpurStreamObj);
				bufferedReaderObj = new BufferedReader(inputStreamReaderObj);
				StringBuilder stringBuilderObj = new StringBuilder();
				String sLine=null;
				while ((sLine = bufferedReaderObj.readLine()) != null) {
					if(sLine!=null){
						sLine = sLine + "\r\n"; 
					}
					stringBuilderObj.append(sLine);
				}
				sReturn = stringBuilderObj.toString();
			}
			
		} catch (SocketTimeoutException e){
			System.out.println("Net_2_4");
			throw e;
		} catch (UnknownHostException e){
			System.out.println("Net_2_5");
			throw new SocketTimeoutException();
		} catch (Exception e) {
			//とりあえず現状ここにくる2013.9.13
			System.out.println("Net_2_e.printStackTrace_mae");
			e.printStackTrace();
			System.out.println("Net_2_6");

			throw new SocketTimeoutException();
		} finally {
			try {
				if (bufferedReaderObj != null)
					bufferedReaderObj.close();
				if (inpurStreamObj != null)
					inpurStreamObj.close();
				if (inputStreamReaderObj != null)
					inputStreamReaderObj.close();
			} catch (IOException e) {
				System.out.println("Net_2_7");
				return null;
			}

		}
		System.out.println("Net_2_END");
		return sReturn;
	}
}
