
package com.vther.spring.batch.ch04.stop;

import org.springframework.batch.item.ItemWriter;

import java.util.List;

/**
 *
 *         2013-3-19下午08:56:21
 */
public class ConsoleWriter implements ItemWriter<String> {

    public void write(List<? extends String> items) throws Exception {
        System.out.print("Write begin:");
        for (String item : items) {
            System.out.print(item + ",");
        }
        System.out.println("Write end!!");
    }

}
