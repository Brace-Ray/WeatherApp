package com.myproject.weatherapp.util;

public class IndexBean {

    private String reason;
    private ResultBean result;
    private int error_code;

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

    public static class ResultBean {
        private String city;
        private LifeBean life;

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public LifeBean getLife() {
            return life;
        }

        public void setLife(LifeBean life) {
            this.life = life;
        }

        public static class LifeBean {
            private KongtiaoBean kongtiao;
            private KongtiaoBean guomin;
            private KongtiaoBean shushidu;
            private KongtiaoBean chuanyi;
            private KongtiaoBean diaoyu;
            private KongtiaoBean ganmao;
            private KongtiaoBean ziwaixian;
            private KongtiaoBean xiche;
            private KongtiaoBean yundong;
            private KongtiaoBean daisan;

            public KongtiaoBean getKongtiao() {
                return kongtiao;
            }

            public void setKongtiao(KongtiaoBean kongtiao) {
                this.kongtiao = kongtiao;
            }

            public KongtiaoBean getGuomin() {
                return guomin;
            }

            public void setGuomin(KongtiaoBean guomin) {
                this.guomin = guomin;
            }

            public KongtiaoBean getShushidu() {
                return shushidu;
            }

            public void setShushidu(KongtiaoBean shushidu) {
                this.shushidu = shushidu;
            }

            public KongtiaoBean getChuanyi() {
                return chuanyi;
            }

            public void setChuanyi(KongtiaoBean chuanyi) {
                this.chuanyi = chuanyi;
            }

            public KongtiaoBean getDiaoyu() {
                return diaoyu;
            }

            public void setDiaoyu(KongtiaoBean diaoyu) {
                this.diaoyu = diaoyu;
            }

            public KongtiaoBean getGanmao() {
                return ganmao;
            }

            public void setGanmao(KongtiaoBean ganmao) {
                this.ganmao = ganmao;
            }

            public KongtiaoBean getZiwaixian() {
                return ziwaixian;
            }

            public void setZiwaixian(KongtiaoBean ziwaixian) {
                this.ziwaixian = ziwaixian;
            }

            public KongtiaoBean getXiche() {
                return xiche;
            }

            public void setXiche(KongtiaoBean xiche) {
                this.xiche = xiche;
            }

            public KongtiaoBean getYundong() {
                return yundong;
            }

            public void setYundong(KongtiaoBean yundong) {
                this.yundong = yundong;
            }

            public KongtiaoBean getDaisan() {
                return daisan;
            }

            public void setDaisan(KongtiaoBean daisan) {
                this.daisan = daisan;
            }

            public static class KongtiaoBean {
                private String v;
                private String des;

                public String getV() {
                    return v;
                }

                public void setV(String v) {
                    this.v = v;
                }

                public String getDes() {
                    return des;
                }

                public void setDes(String des) {
                    this.des = des;
                }
            }
        }
    }
}
