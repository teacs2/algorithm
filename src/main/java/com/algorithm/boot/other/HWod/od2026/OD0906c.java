package com.algorithm.boot.other.HWod.od2026;

public class OD0906c {

    /**
     * 解析32位传感器寄存器数据。
     *
     * @param packet 32位寄存器数据
     * @return 解析结果
     */
    public int parsePacket(int packet) {
        int status = packet & 1;
        if (status == 0) {
            return -1;
        }

        int registerId = (packet >> 1) & 0x3;
        int dataType = (packet >> 3) & 1;
        int factor = (packet >> 4) & 0xff;
        int validLength = (packet >> 12) & 0xf;
        int data = (packet >> 16) & 0x7fff;
        int parity = (packet >> 31) & 1;

        int validData;
        if (dataType == 1) {
            validData = data & ((1 << validLength) - 1);
        } else {
            validData = data;
        }

        int oneCount = Integer.bitCount(validData) + parity;
        if ((oneCount & 1) == 1) {
            return -2;
        }

        if (dataType == 1 && validLength == 0) {
            return -3;
        }

        int result;
        switch (registerId) {
            case 0:
                result = validData & factor;
                break;
            case 1:
                result = validData | factor;
                break;
            case 2:
                result = validData ^ factor;
                break;
            case 3:
                result = ~(validData ^ factor);
                break;
            default:
                return -1;
        }
        return result & 0x0FFFFFFF;
    }

}
