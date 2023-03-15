package rpg.rpgapi.utils;

import org.yaml.snakeyaml.external.biz.base64Coder.Base64Coder;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.TimeUnit;

public class Utils {
    public static String durationToString(long time, boolean now) {
        if (!now) {
            time -= System.currentTimeMillis();
        }

        if (time < 1L) {
            return "<1s";
        }
        long months = TimeUnit.MILLISECONDS.toDays(time) / 30L;
        long days = TimeUnit.MILLISECONDS.toDays(time) % 30L;
        long hours = TimeUnit.MILLISECONDS.toHours(time) - TimeUnit.DAYS.toHours(TimeUnit.MILLISECONDS.toDays(time));
        long minutes = TimeUnit.MILLISECONDS.toMinutes(time) - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(time));
        long seconds = TimeUnit.MILLISECONDS.toSeconds(time) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(time));
        StringBuilder stringBuilder = new StringBuilder();
        if (months > 0L) {
            stringBuilder.append(months).append("msc").append(" ");
        }

        if (days > 0L) {
            stringBuilder.append(days).append("d").append(" ");
        }

        if (hours > 0L) {
            stringBuilder.append(hours).append("h").append(" ");
        }

        if (minutes > 0L) {
            stringBuilder.append(minutes).append("m").append(" ");
        }

        if (seconds > 0L) {
            stringBuilder.append(seconds).append("s");
        }

        return stringBuilder.length() > 0 ? stringBuilder.toString().trim() : time + "ms";
    }

    public static String[] stringArrayFromBase64(final String data) throws IOException {
        final ByteArrayInputStream inputStream = new ByteArrayInputStream(Base64Coder.decodeLines(data));
        final InputStreamReader dataInput = new InputStreamReader(inputStream);
        final String[] items = new String[Integer.parseInt(dataInput.read() + "")];
        for (int i = 0; i < items.length; ++i) {
            final StringBuilder builder = new StringBuilder();
            int read;
            while ((read = dataInput.read()) != 0) {
                builder.append((char) read);
            }
            items[i] = builder.toString();
        }
        dataInput.close();
        return items;
    }
}
