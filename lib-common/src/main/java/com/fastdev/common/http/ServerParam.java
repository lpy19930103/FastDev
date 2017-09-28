package com.fastdev.common.http;


/**
 * Created by lipy on 17/8/7.
 */
public class ServerParam<DTO> {


    /**
     * client : {"caller":"app","ex":{"imei":"861365031254589","mac":"64:cc:2e:f8:26:f9"},"platform":"android"}
     * data : {"mobile":"13666643039","type":"bind"}
     * timestamp : 1501815619851
     */

    private ClientBean client;
    private DTO data;
    private long timestamp;

    public ClientBean getClient() {
        return client;
    }

    public void setClient(ClientBean client) {
        this.client = client;
    }

    public DTO getData() {
        return data;
    }

    public void setData(DTO data) {
        this.data = data;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public static class ClientBean {
        /**
         * caller : app
         * ex : {"imei":"861365031254589","mac":"64:cc:2e:f8:26:f9"}
         * platform : android
         */

        private String caller;
        private ExBean ex;
        private String platform;

        public String getCaller() {
            return caller;
        }

        public void setCaller(String caller) {
            this.caller = caller;
        }

        public ExBean getEx() {
            return ex;
        }

        public void setEx(ExBean ex) {
            this.ex = ex;
        }

        public String getPlatform() {
            return platform;
        }

        public void setPlatform(String platform) {
            this.platform = platform;
        }

        public static class ExBean {
            /**
             * imei : 861365031254589
             * mac : 64:cc:2e:f8:26:f9
             */

            private String imei;
            private String mac;

            public String getImei() {
                return imei;
            }

            public void setImei(String imei) {
                this.imei = imei;
            }

            public String getMac() {
                return mac;
            }

            public void setMac(String mac) {
                this.mac = mac;
            }
        }
    }

}

