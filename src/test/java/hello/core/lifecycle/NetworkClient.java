package hello.core.lifecycle;

public class NetworkClient {

    private  String url;

    public NetworkClient() {
        System.out.println("생성자 호출, url = "+url);
    }

    public void setUrl(String url){
        this.url = url;
    }

    // 서비스 시작시 호출
    public void connect() {
        System.out.println("connect : "+ url);
    }

    public void call(String message) {
        System.out.println("call : " + url + "message = " + message);
    }

    // 서비스 종료시 호출
    public void disconnect(){
        System.out.println("close " + url);
    }

    public void init() throws Exception {
        // 의존관계 주입이 끝나면 호출하겠다.
        System.out.println("NetworkClient.afterPropertiesSet");
        connect();
        call("초기화 연결 메시지");
    }

    public void close() throws Exception {
        // 빈이 종료될때 호출된다.
        System.out.println("NetworkClient.destroy");
        disconnect();
    }
}
