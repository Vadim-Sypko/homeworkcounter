package com.example.homeworkcounter;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.animation.AnimatableView;

public class MainActivity extends AppCompatActivity {
    // Создадим поля для вывода на экран нужных значений
    private TextView textCount; // окно вывода значения счетчика
    private Button button; // кнопка счетчика
    private int count = 0;  // переменная счетчика

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // присваивание переменным активити элементов представления activity_main
        textCount =findViewById(R.id.textCount);
        button=findViewById(R.id.button);
        // выполнение действий при нажатии кнопки
        button.setOnClickListener(Listener);
    }
    //объект обработки нажатия кнопки (слушатель)
    private View.OnClickListener Listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            count++;
            textCount.setText(Integer.toString(count));
        }
    };

    @Override
    protected void onStart() {
        // размещаем тост (контекст, сообщение, длительность сообщения)
        Toast toast = Toast.makeText(this, "Старт активности", Toast.LENGTH_SHORT); //инициализация
        toast.show(); //демонстрация тоста на экране
        super.onStart();
    }

    @Override
    protected void onStop() {
        Toast toast = Toast.makeText(this, "Стоп активности", Toast.LENGTH_SHORT); //инициализация
        toast.setGravity(Gravity.LEFT, 0, 0); // задание позиции на экране(положение, смещение по оси X, смещение по оси Y)
        toast.show(); //демонстрация тоста на экране
        super.onStop();
    }
    // переопределение метода сохранение данных активити
    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("key", count); // запись необходимых данных в контейнер Bundle
        // размещаем вспомогательный тост (контекст, сообщение, длительность)
        Toast toast = Toast.makeText(this, "Запись данных в контейнер Bundle", Toast.LENGTH_SHORT);//инициализация
        toast.show();//демонстрация тоста на экране
    }
    // переопределение метода возврата данных активити
    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        count =savedInstanceState.getInt("key");
        // размещаем вспомогательный тост (контекст, сообщение, длительность)
        Toast toast = Toast.makeText(this, "Считывание данных из контейнера Bundle", Toast.LENGTH_SHORT);//инициализация
        toast.show();//демонстрация тоста на экране
    }

    @Override
    protected void onDestroy() {
        Toast toast = Toast.makeText(this, "Уничтожение активности", Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.BOTTOM,0,0);
        toast.show();
        super.onDestroy();
    }

    @Override
    protected void onPause() {
        Toast toast = Toast.makeText(this,R.string.pause_activity,Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.TOP, 0, 0);
        super.onPause();
    }

    @Override
    protected void onResume() {
        Toast toast = Toast.makeText(this, R.string.resume_activity, Toast.LENGTH_SHORT); // инициализация
        toast.setGravity(Gravity.CENTER, 0,0); // задание позиции на экране (положение, смещение по оси Х, смещение по оси Y)
        // помещение тоста в контейнер
        LinearLayout toastContainer = (LinearLayout) toast.getView();
        // добавление в тост картинки
        ImageView cat = new ImageView(this); // создание объекта картинки (контекст)
        cat.setImageResource(R.drawable.cat); // добавление картинки из ресурсов
        toastContainer.addView(cat, 1); // добавление картинки под индексом 1 в имеющийся контейнер
        toast.show(); // демонстрация тоста на экране
        super.onResume();
    }
}