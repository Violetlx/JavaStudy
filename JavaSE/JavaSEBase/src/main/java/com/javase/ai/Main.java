package com.javase.ai;

import com.alibaba.dashscope.aigc.generation.Generation;
import com.alibaba.dashscope.aigc.generation.GenerationParam;
import com.alibaba.dashscope.aigc.generation.GenerationResult;
import com.alibaba.dashscope.common.Message;
import com.alibaba.dashscope.common.Role;
import com.alibaba.dashscope.exception.ApiException;
import com.alibaba.dashscope.exception.InputRequiredException;
import com.alibaba.dashscope.exception.NoApiKeyException;
import com.alibaba.dashscope.utils.JsonUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {
    public static void callWithMessage() throws NoApiKeyException, ApiException, InputRequiredException {
        Generation gen = new Generation();
        Scanner sc = new Scanner(System.in);
        List<Message> messages = new ArrayList<>();
        Message systemMsg = Message.builder().role(Role.SYSTEM.getValue()).content("You are a helpful assistant.").build();
        messages.add(systemMsg);
        while (true) {
            System.out.println("You:请输入...（exit退出）");
            String input = sc.next();
            if ("exit".equals(input)) {
                break;
            }
            Message userMsg = Message.builder().role(Role.USER.getValue()).content(input).build();
            if (messages.size() == 7) {
                messages.remove(0);
            }
            messages.add(userMsg);
            GenerationParam param = GenerationParam.builder().model("qwen-turbo").messages(messages).apiKey("your-own-key").resultFormat(GenerationParam.ResultFormat.MESSAGE).topP(0.8).build();
            GenerationResult result = gen.call(param);
            System.out.println(result.getOutput().getChoices().get(0).getMessage().getContent());
            // 添加assistant返回到messages列表，user/assistant消息必须交替出现
            if (messages.size() == 7) {
                messages.remove(0);
            }
            messages.add(result.getOutput().getChoices().get(0).getMessage());
        }

    }


    public static void main(String[] args) {
        try {
            callWithMessage();
        } catch (ApiException | NoApiKeyException | InputRequiredException e) {
            System.out.println(e.getMessage());
        }
        System.exit(0);
    }
}


