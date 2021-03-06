package com.dq.xindai.bean;

/**
 * 跳转网页实体类
 * Created by jingang on 2019/1/4.
 */

public class WebData extends ResultBase {

    /**
     * data : {"sign":{"merchantNo":"137130000011039","merOrderNo":"CZ-20190104-00447","jsonEnc":"438627C0C46CF8E1E5AAE67D6AE3CBA29E39D963D704C86C267A9EC08F3FE901CC466F252B3AD4E6A78C156015308FCDCC60EA1764DF6C2949B6F5338DB6E0C180434C4CECCCF99F8C177EB8AC7A5988B31D35E2311186F4A89AED14377BCB49A75CDCB9FE87AC7EB2264B6BA9DC7B6AA90EFF0D612077BDACA40501DE3F762E70AA9A7F0C5604AE5DF97885B9B737D40EDF624C1DDD0C2104B9BEFF290BB8D4CBEC00849090EAFF6CBF3F78E1546F6E176F749B7C1B4DC548035B1C378B65B52E33D88CB2AB8FCD1B4D8930EFA2D3385D29A51F7BA3530D320129E49ABBAE4541319F7FFF92F1C060133371661C0B4B522D351CCAC341E0E7975216F30AC5A0B36F33FEB4F9FB8B7DD01767D394BFF530616C0EC2C6DD7B8B98ADE229F451D78088DFFD4F7CFA7C483A62BE0A0225E2303A1626BE789178DAB5A46489D01F7BEDBC7A5C90343AE708DE0C71C422974D5119E9AA03A48C89BB76B994B9521D881843108A14101502DA53E1E388B259C2","keyEnc":"a87ee7486c09b7962fafa7971bfbf444f3280d7f9472855bff832eb44d3e97cfc2ad43f180d2df1bf6bc78469121e55b2c2fb476e023d71290d1aa67b3e218963239e52e115f86c8da2caf59b6f24f8772bccdfe3d5faf458d96a442652e1009119b2dfaec4a99c74f27f3f0d630166c7024013e460b8fdbde9991690fe10f87ce2848411426e806d78b46160e51e9b5bd8cc19e62a8ff6e9fecf3df0093b48b1cc38b10309637e3344f96c66749db87b88d57193bf20b2cfa60aa66544f7e894da50cca28e71fe077a71dd4b1afc1223bd0e6548481b7c19892e665f3f830f3826e14ba832cff9d7f11321717b92d4560480fb0e2b17d65b3d7776b320eaaa3","sign":"47e9d5960af1cd7eeb77da8ebde2fbb72d03b9cad82f45c0be00c727ac782f4efc1cd58013f6266e104e1f145efc3140dc94209e5a97ab7edf68c83d995d6467e11acf701b2f74ba64f2d3f8cf37f42f138bcc81c78f91614ec8aca039e92f9ff4615787c582ff1e2ed10f94cd2ee84effaf05a92ad04987d78d44aa1cde85179fea915c6ce0add27b06d8cb7f7993468dce25b70d70ece81547d4e521e10760ca2f7e15d0c3a3a53bd9fd03dd78cc203b121fc4980adab60b13a33756c36dfa4d22683efe424b9403022791858521d56ff92a1ee828fb1cac4d1ef639b468484d5e19e451a745f6ed6730c3e2ca8636458cf4f7e8f16e8e7f00f5a0a096b60b"},"url":"https://cg.shanbansyh.com.cn/dep-front/cgbiz/cg1003"}
     */

    private DataBean data;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * sign : {"merchantNo":"137130000011039","merOrderNo":"CZ-20190104-00447","jsonEnc":"438627C0C46CF8E1E5AAE67D6AE3CBA29E39D963D704C86C267A9EC08F3FE901CC466F252B3AD4E6A78C156015308FCDCC60EA1764DF6C2949B6F5338DB6E0C180434C4CECCCF99F8C177EB8AC7A5988B31D35E2311186F4A89AED14377BCB49A75CDCB9FE87AC7EB2264B6BA9DC7B6AA90EFF0D612077BDACA40501DE3F762E70AA9A7F0C5604AE5DF97885B9B737D40EDF624C1DDD0C2104B9BEFF290BB8D4CBEC00849090EAFF6CBF3F78E1546F6E176F749B7C1B4DC548035B1C378B65B52E33D88CB2AB8FCD1B4D8930EFA2D3385D29A51F7BA3530D320129E49ABBAE4541319F7FFF92F1C060133371661C0B4B522D351CCAC341E0E7975216F30AC5A0B36F33FEB4F9FB8B7DD01767D394BFF530616C0EC2C6DD7B8B98ADE229F451D78088DFFD4F7CFA7C483A62BE0A0225E2303A1626BE789178DAB5A46489D01F7BEDBC7A5C90343AE708DE0C71C422974D5119E9AA03A48C89BB76B994B9521D881843108A14101502DA53E1E388B259C2","keyEnc":"a87ee7486c09b7962fafa7971bfbf444f3280d7f9472855bff832eb44d3e97cfc2ad43f180d2df1bf6bc78469121e55b2c2fb476e023d71290d1aa67b3e218963239e52e115f86c8da2caf59b6f24f8772bccdfe3d5faf458d96a442652e1009119b2dfaec4a99c74f27f3f0d630166c7024013e460b8fdbde9991690fe10f87ce2848411426e806d78b46160e51e9b5bd8cc19e62a8ff6e9fecf3df0093b48b1cc38b10309637e3344f96c66749db87b88d57193bf20b2cfa60aa66544f7e894da50cca28e71fe077a71dd4b1afc1223bd0e6548481b7c19892e665f3f830f3826e14ba832cff9d7f11321717b92d4560480fb0e2b17d65b3d7776b320eaaa3","sign":"47e9d5960af1cd7eeb77da8ebde2fbb72d03b9cad82f45c0be00c727ac782f4efc1cd58013f6266e104e1f145efc3140dc94209e5a97ab7edf68c83d995d6467e11acf701b2f74ba64f2d3f8cf37f42f138bcc81c78f91614ec8aca039e92f9ff4615787c582ff1e2ed10f94cd2ee84effaf05a92ad04987d78d44aa1cde85179fea915c6ce0add27b06d8cb7f7993468dce25b70d70ece81547d4e521e10760ca2f7e15d0c3a3a53bd9fd03dd78cc203b121fc4980adab60b13a33756c36dfa4d22683efe424b9403022791858521d56ff92a1ee828fb1cac4d1ef639b468484d5e19e451a745f6ed6730c3e2ca8636458cf4f7e8f16e8e7f00f5a0a096b60b"}
         * url : https://cg.shanbansyh.com.cn/dep-front/cgbiz/cg1003
         */

        private SignBean sign;
        private String url;

        public SignBean getSign() {
            return sign;
        }

        public void setSign(SignBean sign) {
            this.sign = sign;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public static class SignBean {
            /**
             * merchantNo : 137130000011039
             * merOrderNo : CZ-20190104-00447
             * jsonEnc : 438627C0C46CF8E1E5AAE67D6AE3CBA29E39D963D704C86C267A9EC08F3FE901CC466F252B3AD4E6A78C156015308FCDCC60EA1764DF6C2949B6F5338DB6E0C180434C4CECCCF99F8C177EB8AC7A5988B31D35E2311186F4A89AED14377BCB49A75CDCB9FE87AC7EB2264B6BA9DC7B6AA90EFF0D612077BDACA40501DE3F762E70AA9A7F0C5604AE5DF97885B9B737D40EDF624C1DDD0C2104B9BEFF290BB8D4CBEC00849090EAFF6CBF3F78E1546F6E176F749B7C1B4DC548035B1C378B65B52E33D88CB2AB8FCD1B4D8930EFA2D3385D29A51F7BA3530D320129E49ABBAE4541319F7FFF92F1C060133371661C0B4B522D351CCAC341E0E7975216F30AC5A0B36F33FEB4F9FB8B7DD01767D394BFF530616C0EC2C6DD7B8B98ADE229F451D78088DFFD4F7CFA7C483A62BE0A0225E2303A1626BE789178DAB5A46489D01F7BEDBC7A5C90343AE708DE0C71C422974D5119E9AA03A48C89BB76B994B9521D881843108A14101502DA53E1E388B259C2
             * keyEnc : a87ee7486c09b7962fafa7971bfbf444f3280d7f9472855bff832eb44d3e97cfc2ad43f180d2df1bf6bc78469121e55b2c2fb476e023d71290d1aa67b3e218963239e52e115f86c8da2caf59b6f24f8772bccdfe3d5faf458d96a442652e1009119b2dfaec4a99c74f27f3f0d630166c7024013e460b8fdbde9991690fe10f87ce2848411426e806d78b46160e51e9b5bd8cc19e62a8ff6e9fecf3df0093b48b1cc38b10309637e3344f96c66749db87b88d57193bf20b2cfa60aa66544f7e894da50cca28e71fe077a71dd4b1afc1223bd0e6548481b7c19892e665f3f830f3826e14ba832cff9d7f11321717b92d4560480fb0e2b17d65b3d7776b320eaaa3
             * sign : 47e9d5960af1cd7eeb77da8ebde2fbb72d03b9cad82f45c0be00c727ac782f4efc1cd58013f6266e104e1f145efc3140dc94209e5a97ab7edf68c83d995d6467e11acf701b2f74ba64f2d3f8cf37f42f138bcc81c78f91614ec8aca039e92f9ff4615787c582ff1e2ed10f94cd2ee84effaf05a92ad04987d78d44aa1cde85179fea915c6ce0add27b06d8cb7f7993468dce25b70d70ece81547d4e521e10760ca2f7e15d0c3a3a53bd9fd03dd78cc203b121fc4980adab60b13a33756c36dfa4d22683efe424b9403022791858521d56ff92a1ee828fb1cac4d1ef639b468484d5e19e451a745f6ed6730c3e2ca8636458cf4f7e8f16e8e7f00f5a0a096b60b
             */

            private String merchantNo;
            private String merOrderNo;
            private String jsonEnc;
            private String keyEnc;
            private String sign;

            public String getMerchantNo() {
                return merchantNo;
            }

            public void setMerchantNo(String merchantNo) {
                this.merchantNo = merchantNo;
            }

            public String getMerOrderNo() {
                return merOrderNo;
            }

            public void setMerOrderNo(String merOrderNo) {
                this.merOrderNo = merOrderNo;
            }

            public String getJsonEnc() {
                return jsonEnc;
            }

            public void setJsonEnc(String jsonEnc) {
                this.jsonEnc = jsonEnc;
            }

            public String getKeyEnc() {
                return keyEnc;
            }

            public void setKeyEnc(String keyEnc) {
                this.keyEnc = keyEnc;
            }

            public String getSign() {
                return sign;
            }

            public void setSign(String sign) {
                this.sign = sign;
            }
        }
    }
}
